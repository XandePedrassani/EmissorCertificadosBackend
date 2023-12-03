package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import lombok.Data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonalDataDto implements Serializable {

    @JsonIgnore
    private String idPersonalData;
    
    @JsonIgnore
    private String idEvento;
    
    @JsonProperty("instituicao")
    private String dsInstituicao;

    @JsonProperty("local")
    private String dsLocal; // TODO change this for id;

    // @JsonProperty("logo")
    // private byte[] logo;

    // @JsonProperty("backgroundImage")
    // private byte[] backgroundImage;

}
