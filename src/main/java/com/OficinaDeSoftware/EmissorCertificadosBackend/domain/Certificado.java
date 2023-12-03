package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

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
    private String idCertificado;
    private String idEvento;
    private String idLocal;
    private String urlLogo;
    private String dsCertificado;
    private String dsNomeEmissor;
    private LocalDate dtConclusao;
    private Integer nrCargaHoraria;
    private String dsTitulo;
    private String dsNomeEvento;
    private String htmlCertificado;
    private String idCertificadoModelo;
    private String modelo;
    private PersonalData personalData;
}
