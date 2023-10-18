package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.google.api.client.util.DateTime;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "certificado")
public class Certificado {
    
    @Id
    private String idlocal;
    private String urlLogo;
    private String dsCertificado;
    private String dsNomeEmissor;
    private LocalDate dtConclusao;
    private Integer nrCargaHoraria;
    private String dsTitulo;
    private String dsNomeEvento;
    private String xmlCertificado;
    private String idCertificadoModelo;
}
