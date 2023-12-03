package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.EventoParticipante;

public interface EventoParticipanteRepository extends MongoRepository<EventoParticipante, String> {
    public boolean existsByNrUuidParticipanteAndIdEvento( String nrUuidParticipante, String idEvento );
    public List<EventoParticipante> findAllByIdEvento( String idEvento );
    public void deleteByIdEventoAndNrUuidParticipante( String idEvento, String nrUuidParticipante );
}
