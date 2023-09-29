package com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CredentialsDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderEnum;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.UserService;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.auth.Provider.ProviderTokenService;

@Service
public class AuthenticationService {

    @Autowired
    private UserService userService;

    @Autowired
    private ProviderTokenService providerTokenService;

    // TODO o certo era isso ser dinâmico, ter os outros services no caso, mas o factory parece não funcionar nesse caso, por conta do @Autowired  
    public AuthenticationService( @Qualifier("googleProviderTokenService") ProviderTokenService providerToken ){
        this.providerTokenService = providerToken;
    }
    
    public UserDto authenticate( CredentialsDto credentialsDto ) throws RuntimeException {

        if( credentialsDto.getTypeProvider() != ProviderEnum.GOOGLE ){
            throw new RuntimeException("Unknow provider");
        }

        final ProviderModel provider = providerTokenService.process( credentialsDto.getToken() );

        // TODO trocar por ModelMapper 
        final UserDto userDto = new UserDto( provider.getNrUuid(), provider.getEmail(), provider.getName() );

        userService.save( userDto );

        return userDto;
    }

    public UserDto findByNrUuid( String nrUuid ) {

        final User user = userService.findByNrUuid( nrUuid );

        if( user == null ){
            throw new RuntimeException("Invalid login");
        }

        // TODO trocar por ModelMapper 
        return new UserDto( user.getNrUuid(), user.getEmail(), user.getName() );
    }

}
