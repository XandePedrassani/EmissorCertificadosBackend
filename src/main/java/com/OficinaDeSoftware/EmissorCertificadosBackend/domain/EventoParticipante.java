package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventoParticipante {
    
    private String idEventoUsuario;
    private String idEvento;
    private String nrUuiParticipante;
}
