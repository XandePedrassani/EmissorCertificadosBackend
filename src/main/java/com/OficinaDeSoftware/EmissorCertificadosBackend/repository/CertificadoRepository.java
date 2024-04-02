package com.OficinaDeSoftware.EmissorCertificadosBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.Certificado;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {}
