package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoParticipanteDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.EventoParticipanteService;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/api/evento/participante")
public class EventoParticipanteController {

    @Autowired
    private EventoParticipanteService service;

    // TODO alterar para quando ocorrer algum erro, ter uma mensagem de retorno especificando.

    @PostMapping
    public ResponseEntity<UserDto> insert( @RequestBody EventoParticipanteDto participante ) {
       try {
            return ResponseEntity.status( HttpStatus.CREATED ).body( service.insert( participante ) ); 
        } catch ( ObjectNotFoundException e ) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body( null ); 
        } catch ( Exception e ) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body(null ); 
        }
    }

    @DeleteMapping( "/{idEvento}/{nrUuidParticipante}" )
    public ResponseEntity<Void> delete( @PathVariable String idEvento, @PathVariable String nrUuidParticipante ) {
        try {
            service.deleteByIdEventoAndNrUuidParticipante( idEvento, nrUuidParticipante );
            return ResponseEntity.ok().body(null); 
        } catch ( ObjectNotFoundException e ) {
            return ResponseEntity.status( HttpStatus.BAD_REQUEST ).body(null ); 
        } catch ( Exception e ) {
            return ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR ).body( null ); 
        }
    }
    
}
