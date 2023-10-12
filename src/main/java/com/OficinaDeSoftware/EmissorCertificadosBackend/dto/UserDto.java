package com.OficinaDeSoftware.EmissorCertificadosBackend.dto;

import jakarta.validation.constraints.NotNull;

import com.OficinaDeSoftware.EmissorCertificadosBackend.model.RoleEnum;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    
    @NotNull
    private String nrUuid;
    
    @NotNull
    private String email;

    private String name;

    private String accessToken;

    @NotNull
    private List<RoleEnum> roles;
}
