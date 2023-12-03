package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.EventoParticipanteConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.UserConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.EventoParticipante;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoParticipanteDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.EventoParticipanteRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.UserRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@Service
public class EventoParticipanteService {
    
    @Autowired
    private EventoParticipanteRepository repository;

    @Autowired
    private EventoParticipanteConverter converter;

    @Autowired
    UserRepository usuarioRepository;

    @Autowired
    UserConverter usuarioConverter;

    public List<EventoParticipante> findAll() {
        return repository.findAll();
    }

    public EventoParticipante findById(String codigo) {
        return repository.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("Evento/Participante não encontrado"));
    }

    public UserDto insert( final EventoParticipanteDto participanteDto ) {

        EventoParticipante participante = converter.convertToEntity( participanteDto );
        
        final User user = usuarioRepository.findByEmail( participante.getDsEmail() );

        if( user == null ) {
           throw new ObjectNotFoundException("Usuario não encontrado");
        }

        if( repository.existsByNrUuidParticipanteAndIdEvento( user.getNrUuid(), participanteDto.getIdEvento() ) ){
            return usuarioConverter.convertToDto( user );
        }

        participante.setNrUuidParticipante( user.getNrUuid() );

        repository.insert( participante );

        return usuarioConverter.convertToDto( user );

    }

    public List<EventoParticipante> findAllByIdEvento( final String idEvent ) {
        return repository.findAllByIdEvento( idEvent );
    };

    public EventoParticipante update(EventoParticipanteDto local) {
        EventoParticipante localAtualizado = findById(local.getIdEventoUsuario());
        BeanUtils.copyProperties(local, localAtualizado);
        return repository.save(localAtualizado);
    }

    public void delete(String codigo) {
        findById(codigo);
        repository.deleteById(codigo);
    }

    public void deleteByIdEventoAndNrUuidParticipante( final String idEvento, final String nrUuidParticipante ) {
        repository.deleteByIdEventoAndNrUuidParticipante( idEvento, nrUuidParticipante );
    }
}
