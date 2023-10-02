package com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth.Provider;

import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;

@Service
public interface ProviderTokenService {
    public ProviderModel process( final String tokenID ) throws RuntimeException;
}
