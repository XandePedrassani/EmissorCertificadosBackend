package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import lombok.Data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "personaldata")

public class PersonalData {

    @Id
    private String idPersonalData;
    private String idEvento;

    @JsonProperty("instituicao")
    private String dsInstituicao;

    @JsonProperty("local")
    private String dsLocal; // TODO change this for id;

    // TODO Implementar rotina que guarda

    // @JsonProperty("logo")
    // private byte[] logo;

    // @JsonProperty("backgroundImage")
    // private byte[] backgroundImage;
    
}
