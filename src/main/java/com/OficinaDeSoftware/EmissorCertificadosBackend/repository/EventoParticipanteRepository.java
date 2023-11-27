package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.EventoParticipante;

public interface EventoParticipanteRepository extends MongoRepository<EventoParticipante, String> {}
