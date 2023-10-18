package com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.UserConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CredentialsDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderEnum;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.RoleEnum;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.UserService;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth.Provider.ProviderTokenService;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;

    private ProviderTokenService providerTokenService;

    public AuthenticationService( ProviderTokenService providerToken ){
        this.providerTokenService = providerToken;
    }
    
    public UserDto authenticate( CredentialsDto credentialsDto ) throws RuntimeException {

        if( credentialsDto.getTypeProvider() != ProviderEnum.GOOGLE ){
            throw new RuntimeException("Unknow provider");
        }

        final ProviderModel provider = providerTokenService.process( credentialsDto.getIdToken() );

        final User registeredUser = userService.findByNrUuid( provider.getNrUuid() );

        if( registeredUser != null ){
            return userConverter.convertToDto( registeredUser );
        }

        return registerUser( provider );
    }

    public UserDto registerUser( final ProviderModel provider ) {

        UserDto userDto = userConverter.convertToDto( provider );
        userDto.setRoles( Arrays.asList( RoleEnum.ROLE_USER ) );
        userService.save( userDto );

        return userDto;
    }
}
