package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.Certificado;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CertificadoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.EventoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.CertificadoRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.CertificadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banco/teste")
public class ControllerTesteBanco {
    @Autowired /* IC/CD ou CDI - Injeção de dependencia */
    private CertificadoRepository certificadoRepository;
    @GetMapping( "/hello" )
    public String helloWord(){
        return "Hello Word";
    }

    @PostMapping("/certificados")
    public void criarCertificado(@RequestBody Certificado certificado) {
        Certificado certificado1 = certificadoRepository.save(certificado);
    }
}
