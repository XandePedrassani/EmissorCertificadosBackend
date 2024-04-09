package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Certificado;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin.CertificadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
