package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import java.time.LocalDateTime;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventoCheckinDto {
    
    @Id
    private String idEventoCheckin;
    private LocalDateTime dhCheckin;
    private LocalDateTime dhCheckout;
    private String nrUuidParticipante;
    private String idEventoData;
}
