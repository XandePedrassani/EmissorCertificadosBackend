package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import org.springframework.beans.factory.annotation.Value;

import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderEnum;

import lombok.Data;

@Data
public class CredentialsDto {

    @Value("#( T(com.example.enums.Property).parse('${custom.property}') )")
    private ProviderEnum typeProvider;

    private String token;

    public CredentialsDto() {
        super();
    }

    public CredentialsDto( String token, ProviderEnum typeProvider ) {
        this.token = token;
        this.typeProvider = typeProvider;
    }
}
