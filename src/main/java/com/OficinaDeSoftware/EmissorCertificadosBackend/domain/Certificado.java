package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "seq_certificado", sequenceName = "seq_certificado", allocationSize = 1, initialValue = 1)
public class Certificado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_certificado")
    private Long idCertificado;
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
    //private PersonalData personalData;
}
