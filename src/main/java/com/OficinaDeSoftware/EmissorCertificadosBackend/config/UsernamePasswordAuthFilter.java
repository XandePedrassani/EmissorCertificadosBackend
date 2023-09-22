package com.OficinaDeSoftware.EmissorCertificadosBackend.config;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpMethod;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CredentialsDto;

public class UsernamePasswordAuthFilter extends OncePerRequestFilter {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    private final UserAuthenticationProvider userAuthenticationProvider;

    public UsernamePasswordAuthFilter(UserAuthenticationProvider userAuthenticationProvider) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse,
            FilterChain filterChain ) throws ServletException, IOException {

        if ("/api/auth/signIn".equals(httpServletRequest.getServletPath() )
                && HttpMethod.POST.matches(httpServletRequest.getMethod())) {
                    
            CredentialsDto credentialsDto = MAPPER.readValue(httpServletRequest.getInputStream(), CredentialsDto.class);

            try {
                SecurityContextHolder.getContext().setAuthentication( userAuthenticationProvider.validateCredentials(credentialsDto) );
            } catch ( RuntimeException e ) {
                SecurityContextHolder.clearContext();
                throw e;
            } 
        }

        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}