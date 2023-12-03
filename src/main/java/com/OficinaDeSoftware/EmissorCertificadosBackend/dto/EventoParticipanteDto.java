package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoParticipanteDto {
    
    @JsonIgnore
    private String idEventoUsuario;

    @JsonProperty( "idEvent" )
    private String idEvento;

    @JsonProperty( "email" )
    private String dsEmail;

    @JsonIgnore
    private String nrUuiParticipante;
}
