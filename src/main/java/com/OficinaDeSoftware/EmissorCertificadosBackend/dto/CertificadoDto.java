package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.time.LocalDate;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificadoDto {
    
    @Id
    private String idCertificado;
    private String idLocal;
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
