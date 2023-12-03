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
@Document(collection = "eventocheckin")
public class EventoCheckin {
    
    @Id 
    private String idEventoCheckin;
    private LocalDateTime dhCheckin;
    private LocalDateTime dhCheckout;
    private String nrUuidParticipante;
    private String idEventoData;
}
