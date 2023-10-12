package com.OficinaDeSoftware.EmissorCertificadosBackend.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;

@Component
public class UserConverter {

  @Autowired
  private ModelMapper modelMapper;

  public UserDto convertToDto( final ProviderModel provider ){

    if( provider == null ){
      return null;
    }

    return modelMapper.map( provider, UserDto.class );
    
  }

  public UserDto convertToDto( final User user ) {

    if( user == null ) {
      return null;
    }

    return modelMapper.map( user, UserDto.class );
  } 

  public User convertToEntity( final UserDto dto ) {

    if( dto == null ) {
      return null;
    }

    return modelMapper.map( dto, User.class );

  }

}