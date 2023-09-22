package com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CredentialsDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.factory.ProviderTokenFactory;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderEnum;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.UserService;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth.Provider.ProviderTokenService;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;
    
    public UserDto authenticate( CredentialsDto credentialsDto ) throws RuntimeException {

        if( credentialsDto.getTypeProvider() != ProviderEnum.GOOGLE ){
            throw new RuntimeException("Unknow provider");
        }

        ProviderTokenService providerTokenService = ProviderTokenFactory.create( credentialsDto.getTypeProvider() );
        ProviderModel provider = providerTokenService.process( credentialsDto.getToken() );

        // TODO trocar por ModelMapper 
        UserDto userDto = new UserDto( provider.getNrUuid(), provider.getEmail(), provider.getName() );

        userService.save( userDto );

        return userDto;
    }

    public UserDto findByNrUuid( String nrUuid ) {

        User user = userService.findByNrUuid( nrUuid );

        if( user == null ){
            throw new RuntimeException("Invalid login");
        }

        // TODO trocar por ModelMapper 
        return new UserDto( user.getNrUuid(), user.getEmail(), user.getName() );
    }

}
