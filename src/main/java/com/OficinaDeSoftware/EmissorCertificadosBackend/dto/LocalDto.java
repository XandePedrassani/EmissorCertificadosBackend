package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocalDto {
    
    @Id
    private String idLocal;
    private String dsAuditorio;
    private String dsBloco;
    private String dsSala;
    private Integer qtdParticipoantes;
}
