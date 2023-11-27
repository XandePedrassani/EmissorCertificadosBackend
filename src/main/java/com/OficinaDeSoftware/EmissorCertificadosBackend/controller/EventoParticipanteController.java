package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.EventoParticipante;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoParticipanteDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.EventoParticipanteService;

@RestController
@RequestMapping(value = "evento/participante")
public class EventoParticipanteController {

    @Autowired
    private EventoParticipanteService service;

    @GetMapping("/inserir")
    public ResponseEntity<EventoParticipante> insert(@RequestBody EventoParticipanteDto EventoParticipanteDto){
        return ResponseEntity.ok(service.insert(EventoParticipanteDto));
    }
}
