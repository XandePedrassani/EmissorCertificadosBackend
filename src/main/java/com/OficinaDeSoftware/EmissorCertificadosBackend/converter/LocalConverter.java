package com.OficinaDeSoftware.EmissorCertificadosBackend.converter;

import java.util.Objects;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.Local;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.LocalDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.model.ProviderModel;

@Component
public class LocalConverter {

  @Autowired
  private ModelMapper modelMapper;

  public LocalDto convertToDto( final ProviderModel provider ){

    return Objects.isNull(provider) ? null : modelMapper.map( provider, LocalDto.class );
    
  }

  public LocalDto convertToDto( final Local user ) {

    return Objects.isNull(user) ? null : modelMapper.map( user, LocalDto.class );

  } 

  public Local convertToEntity( final LocalDto dto ) {

    return Objects.isNull(dto) ? null : modelMapper.map( dto, Local.class );
    
  }

}