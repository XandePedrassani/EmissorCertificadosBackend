package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Data
@Document( collection = "user")
public class User {

    public User( String nrUuid, String name, String email ){
        this.nrUuid = nrUuid;
        this.name = name;
        this.email = email;
    }

    @Id
    private String nrUuid;

    @NotNull
    private String name;

    @Email
    private String email;
}
