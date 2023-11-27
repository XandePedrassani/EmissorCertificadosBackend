package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.EventoConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.Evento;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.EventoPersonalizado;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.Local;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.EventoRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@Service
public class EventoService {
    
    @Autowired
    private EventoRepository repository;
    @Autowired
    private EventoConverter converter;
    @Autowired
    private UserService userService;
    @Autowired
    private LocalService localService;

    public List<Evento> findAll() {
        return repository.findAll();
    }

    public List<EventoPersonalizado> findAllPersonalizado() {
        List<Evento> evento = findAll();
        List<User> organizador = userService.findAll();
        List<Local> local = localService.findAll();
        List<EventoPersonalizado> eventoPersonalizado = null;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        evento.forEach(e -> {
            String org = organizador.stream()
                                   .filter(value -> value.getNrUuid().equals(e.getNrUuidResponsavel()))
                                   .findFirst()
                                   .orElseThrow(() -> new ObjectNotFoundException("Não foi possível obter o organizador"))
                                   .getName();
        
            String loc = local.stream()
                             .filter(value -> value.getIdLocal().equals(e.getIdLocal()))
                             .findFirst()
                             .orElseThrow(() -> new ObjectNotFoundException("Não foi possível obter o local"))
                             .getDsAuditorio();
        
            eventoPersonalizado.add(new EventoPersonalizado(
                    e.getDsNome(),
                    e.getDsInformacoes(),
                    e.getDhInicio().format(dateFormatter),
                    e.getDhInicio().format(timeFormatter),
                    e.getDhFim().format(dateFormatter),
                    e.getDhFim().format(timeFormatter),
                    loc,
                    org,
                    e.getIdEvento()
            ));
        });

        return eventoPersonalizado;
    }

    public Evento findById(String codigo) {
        return repository.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("Evento não encontrado"));
    }

    public Evento insert(EventoDto evento) {
        return repository.insert(converter.convertToEntity(evento));
    }

    public Evento update(EventoDto evento) {
        Evento eventoAtualizado = findById(evento.getIdEvento());
        BeanUtils.copyProperties(evento, eventoAtualizado);
        return repository.save(eventoAtualizado);
    }

    public void delete(String codigo) {
        findById(codigo);
        repository.deleteById(codigo);
    }
}
