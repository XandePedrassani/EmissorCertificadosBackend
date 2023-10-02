package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserDto {
    
    @NotNull
    private String nrUuid;
    
    @NotNull
    private String email;

    private String name;

    private String token;

    public UserDto( String nrUuid, String email, String name ){
        this.nrUuid = nrUuid;
        this.email = email;
        this.name = name;
    }

}
