package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "local")
public class Local {
    
    @Id
    private String idlocal;
    private String dsAuditorio;
    private String dsBloco;
    private String dsSala;
    private Integer qtdParticipoantes;
}
