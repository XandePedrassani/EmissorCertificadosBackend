package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document( collection="dateevent" )
public class DateEvent {

    @Id
    private String idDateEvent;
    private String idEvento;
    private String date;
    private String startTime;
    private String endTime;
}
