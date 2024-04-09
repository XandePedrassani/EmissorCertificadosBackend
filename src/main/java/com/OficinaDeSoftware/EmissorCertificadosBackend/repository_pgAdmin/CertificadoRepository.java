package com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Certificado;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificadoRepository extends JpaRepository<Certificado, Long> {}
