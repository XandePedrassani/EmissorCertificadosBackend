package com.OficinaDeSoftware.EmissorCertificadosBackend.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OficinaDeSoftware.EmissorCertificadosBackend.config.UserAuthenticationProvider;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserAuthenticationProvider userAuthenticationProvider;

    public AuthController( UserAuthenticationProvider userAuthenticationProvider ) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }
    
    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn( @AuthenticationPrincipal UserDto user ){
        user.setToken(userAuthenticationProvider.createToken(user));
        return ResponseEntity.ok(user);
    } 
}
