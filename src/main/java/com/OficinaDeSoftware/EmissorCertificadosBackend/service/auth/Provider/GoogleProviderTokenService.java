package com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth.Provider;

import java.util.Collections;

import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;

import org.springframework.beans.factory.annotation.Value;

@Service("googleProviderTokenService")
public class GoogleProviderTokenService implements ProviderTokenService {

    @Value("${spring.security.oauth2.client.registration.google.clientId}")
    private String clientID;

    @Override 
    public ProviderModel process( String tokenID ) throws RuntimeException {

        final GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(), new GsonFactory())
        .setAudience(Collections.singletonList( clientID ) )
        .build();

        GoogleIdToken idToken;

        try {
            idToken = verifier.verify(tokenID);
        } catch ( Exception e ) {
            e.printStackTrace();
            throw new RuntimeException( "Fail on verify ID Token" );
        }

        if( idToken == null ){
            throw new RuntimeException("ID Token invalid");
        }

        final Payload payload = idToken.getPayload();

        final ProviderModel providerModel = ProviderModel.builder()
        .name( payload.get("name").toString() )
        .nrUuid( payload.getSubject() )
        .email( payload.getEmail() )
        .build();

        return providerModel;
    }

}
