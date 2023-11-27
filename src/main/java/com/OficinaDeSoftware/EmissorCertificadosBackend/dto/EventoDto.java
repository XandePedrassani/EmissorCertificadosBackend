package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDto {
    
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
