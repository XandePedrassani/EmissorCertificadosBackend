package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificadoDto {
    
    @Id
    @JsonIgnore
    private String idCertificado;

    @JsonIgnore
    private String idEvento;
    
    @JsonIgnore
    private String idLocal;
    
    @JsonIgnore
    private String urlLogo;
    
    @JsonIgnore
    private String dsCertificado;
    
    @JsonIgnore
    private String dsNomeEmissor;

    @JsonIgnore
    private LocalDate dtConclusao;

    @JsonIgnore
    private Integer nrCargaHoraria;

    @JsonIgnore
    private String dsTitulo;
    
    @JsonIgnore
    private String dsNomeEvento;
    
    @JsonProperty( "htmlModel" )
    private String htmlCertificado;

    @JsonProperty( "modelo" )
    private String modelo;
    
    @JsonIgnore
    private String idCertificadoModelo;

   // @JsonProperty( "personalData" )
   // private PersonalDataDto personalData;
}
