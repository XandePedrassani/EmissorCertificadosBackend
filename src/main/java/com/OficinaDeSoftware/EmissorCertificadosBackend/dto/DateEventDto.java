package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class DateEventDto implements Serializable {

    @JsonIgnore
    @Id
    private String idDateEvent;

    @JsonIgnore
    private String idEvento;

    private String date;
    private String startTime;
    private String endTime;
}