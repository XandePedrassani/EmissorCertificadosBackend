package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoDto {
    
    @Id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("idEvent")
    private String idEvento;

    @JsonProperty("name")
    private String dsNome;

    @JsonProperty("dateStart")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dhInicio;

    @JsonProperty("dateEnd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dhFim;

    @JsonProperty("workload")
    private Integer nrCargaHoraria;

    @JsonProperty("informations")
    private String dsInformacoes;

    @JsonProperty("nrUuidAccountable")
    private String nrUuidResponsavel;

    @JsonProperty("participants")
    List<User> participantes;

    @JsonIgnore
    private String idLocal;

    @JsonProperty("dates")
    private List<DateEventDto> dates;

    @JsonProperty( "certificate" )
    private CertificadoDto certificado;

}

