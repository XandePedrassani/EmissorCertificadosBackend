package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.User;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/findAll")
    public List<User> user(){
        return service.findAll();
    }

    // Example 
    // @PostMapping( "/create" )
    // @ResponseStatus( HttpStatus.CREATED )
    // public void save( @RequestBody User user ){
    //     service.save( user );
    // }

}
