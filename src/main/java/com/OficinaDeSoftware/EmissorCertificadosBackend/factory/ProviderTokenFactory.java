package com.OficinaDeSoftware.EmissorCertificadosBackend.factory;

import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderEnum;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth.Provider.GoogleProviderTokenService;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth.Provider.ProviderTokenService;

// TODO class não utilizada 
public class ProviderTokenFactory {
    
    public static ProviderTokenService create( final ProviderEnum provider ){

        switch (provider) {
            case GOOGLE:
                return new GoogleProviderTokenService();
            default:
                return null;
        }
    }
}
