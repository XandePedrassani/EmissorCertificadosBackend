package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.UserConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.UserDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private UserConverter userConverter;

    public List<User> findAll() {
        return repository.findAll();
    }

    public void save( final UserDto userDto ){
        this.repository.save( userConverter.convertToEntity( userDto ) );
    }

    public User findByNrUuid( final String nrUuid ){

        Optional<User> user = this.repository.findById( nrUuid );

        if( user.isPresent() ){
            return user.get();
        }

        return null;
    }
    
}
