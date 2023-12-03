package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EventoPersonalizado {
    
    private String nome;
    private String descricao;
    private String dsDateStart;
    private String dsTimeStart;
    private String dsDateEnd;
    private String dsTimeEnd;
    private String dsAuditorio;
    private String organizador;
    private String id;
}
