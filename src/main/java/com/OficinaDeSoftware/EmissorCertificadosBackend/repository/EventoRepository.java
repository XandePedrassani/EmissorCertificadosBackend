package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.Evento;

public interface EventoRepository extends MongoRepository<Evento, String> {

    List<Evento> findAllByNrUuidResponsavel( String nrUuidResponsavel );

    // List<Evento> findAllPersonalizado();
}
