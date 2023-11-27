package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.EventoParticipanteConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.EventoParticipante;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoParticipanteDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.EventoParticipanteRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@Service
public class EventoParticipanteService {
    
    @Autowired
    private EventoParticipanteRepository repository;

    @Autowired
    private EventoParticipanteConverter converter;

    public List<EventoParticipante> findAll() {
        return repository.findAll();
    }

    public EventoParticipante findById(String codigo) {
        return repository.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("Evento/Participante não encontrado"));
    }

    public EventoParticipante insert(EventoParticipanteDto eventoParticipanteDto) {
        return repository.insert(converter.convertToEntity(eventoParticipanteDto));
    }

    public EventoParticipante update(EventoParticipanteDto local) {
        EventoParticipante localAtualizado = findById(local.getIdEventoUsuario());
        BeanUtils.copyProperties(local, localAtualizado);
        return repository.save(localAtualizado);
    }

    public void delete(String codigo) {
        findById(codigo);
        repository.deleteById(codigo);
    }
}
