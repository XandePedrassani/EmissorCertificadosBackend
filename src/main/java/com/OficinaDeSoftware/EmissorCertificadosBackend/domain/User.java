package com.OficinaDeSoftware.EmissorCertificadosBackend.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.OficinaDeSoftware.EmissorCertificadosBackend.model.RoleEnum;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document( collection = "user")
public class User {

    @Id
    private String nrUuid;

    @NotNull
    private String name;

    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private List<RoleEnum> roles;
    
}