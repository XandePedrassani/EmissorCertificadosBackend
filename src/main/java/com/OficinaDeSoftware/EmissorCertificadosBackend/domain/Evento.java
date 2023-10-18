package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "evento")
public class Evento {
    
    @Id
    private String idEvento;
    private String dsNome;
    private LocalDateTime dhInicio;
    private LocalDateTime dhFim;
    private Integer nrCargaHoraria;
    private String dsInformacoes;
    private String nrUuidResponsavel;
    private String idLocal;
}
