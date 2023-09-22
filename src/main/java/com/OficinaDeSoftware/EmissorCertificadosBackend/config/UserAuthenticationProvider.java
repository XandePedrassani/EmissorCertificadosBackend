package com.OficinaDeSoftware.EmissorCertificadosBackend.config;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import org.springframework.security.core.Authentication;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CredentialsDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth.AuthenticationService;

import jakarta.annotation.PostConstruct;

@Component
public class UserAuthenticationProvider {
    
    // TODO ajustar para pegar do application.properties 
    // @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey = "BATATINHA123";

    @Autowired
    private AuthenticationService authenticationService; 

    @PostConstruct
    protected void init(){
        secretKey = Base64.getEncoder().encodeToString( secretKey.getBytes() );
    }

    public String createToken( UserDto user ){

        Date now = new Date();
        Date validity = validyToken( now );

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withIssuer(user.getNrUuid())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);
    }

    public Date validyToken( Date now ){
        int oneHourInMilliseconds = 3600000;
        return new Date( now.getTime() + oneHourInMilliseconds );
    }

    public Authentication validateToken( String token ) {
        Algorithm algorithm = Algorithm.HMAC256( secretKey );

        JWTVerifier verifier = JWT.require( algorithm ).build();

        DecodedJWT decoded = verifier.verify( token );

        UserDto user = authenticationService.findByNrUuid( decoded.getIssuer() );

        return new UsernamePasswordAuthenticationToken( user, null, Collections.emptyList() );
    }

    public Authentication validateCredentials( CredentialsDto credentialsDto ) throws RuntimeException {
        UserDto user = authenticationService.authenticate( credentialsDto );
        return new UsernamePasswordAuthenticationToken( user, null, Collections.emptyList() );
    }

}
