package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.CertificadoConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto_PgAdmin.Certificado;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.CertificadoDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository_pgAdmin.CertificadoRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@Service
public class CertificadoService {
    
    @Autowired
    private CertificadoRepository repository;

    @Autowired
    private CertificadoConverter converter;

    public List<Certificado> findAll() {
        return repository.findAll();
    }

    public Certificado findById(Long codigo) {
        return repository.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("Certificado não encontrado"));
    }

    public Certificado insert(CertificadoDto certificado) {
        return repository.save(converter.convertToEntity(certificado));
    }

    /*public Certificado update(CertificadoDto certificado) {
        Certificado certificadoAtualizado = findById(certificado.getIdCertificado());
        BeanUtils.copyProperties(certificado, certificadoAtualizado);
        return repository.save(certificadoAtualizado);
    }

    public void delete(String codigo) {
        findById(codigo);
        repository.deleteById(codigo);
    }*/
}
