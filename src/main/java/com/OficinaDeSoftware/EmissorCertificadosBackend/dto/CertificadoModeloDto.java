package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificadoModeloDto {
    
    @Id
    private String idCertificadoModelo;
    private String xmlModelo;
}
