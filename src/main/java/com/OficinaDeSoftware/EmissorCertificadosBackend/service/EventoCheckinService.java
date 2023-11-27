package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.EventoCheckinConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.EventoCheckin;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoCheckinDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.EventoCheckinRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@Service
public class EventoCheckinService {
    
    @Autowired
    private EventoCheckinRepository repository;

    @Autowired
    private EventoCheckinConverter converter;

    public List<EventoCheckin> findAll() {
        return repository.findAll();
    }

    public EventoCheckin findById(String codigo) {
        return repository.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("EventoCheckin não encontrado"));
    }

    public EventoCheckin insert(EventoCheckinDto eventoCheckin) {
        return repository.insert(converter.convertToEntity(eventoCheckin));
    }

    public EventoCheckin update(EventoCheckinDto eventoCheckin) {
        EventoCheckin eventoCheckinAtualizado = findById(eventoCheckin.getIdEventoCheckin());
        BeanUtils.copyProperties(eventoCheckin, eventoCheckinAtualizado);
        return repository.save(eventoCheckinAtualizado);
    }

    public void delete(String codigo) {
        findById(codigo);
        repository.deleteById(codigo);
    }
}
