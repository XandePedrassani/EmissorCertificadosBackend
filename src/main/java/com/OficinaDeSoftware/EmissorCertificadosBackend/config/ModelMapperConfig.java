package com.OficinaDeSoftware.EmissorCertificadosBackend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;

@Configuration
public class ModelMapperConfig {
    
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.createTypeMap( User.class, UserDto.class )
        .<String>addMapping( src -> src.getNrUuid(), ( dest, value ) -> dest.setNrUuid( value ) );

        return modelMapper;
    }

}
