package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import org.springframework.beans.factory.annotation.Value;

import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderEnum;

import lombok.Data;

@Data
public class CredentialsDto {

    @Value("#( T(com.example.enums.Property).parse('${custom.property}') )")
    private ProviderEnum typeProvider;

    private String idToken;

    public CredentialsDto() {
        super();
    }

    public CredentialsDto( String idToken, ProviderEnum typeProvider ) {
        this.idToken = idToken;
        this.typeProvider = typeProvider;
    }
}
