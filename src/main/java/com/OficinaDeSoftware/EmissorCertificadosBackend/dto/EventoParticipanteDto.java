package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoParticipanteDto {
    
    private String idEventoUsuario;
    private String idEvento;
    private String nrUuiParticipante;
}
