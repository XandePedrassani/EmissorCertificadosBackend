package com.OficinaDeSoftware.EmissorCertificadosBackend.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OficinaDeSoftware.EmissorCertificadosBackend.converter.LocalConverter;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.Local;
import com.OficinaDeSoftware.EmissorCertificadosBackend.dto.LocalDto;
import com.OficinaDeSoftware.EmissorCertificadosBackend.repository.LocalRepository;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.exception.ObjectNotFoundException;

@Service
public class LocalService {
    
    @Autowired
    private LocalRepository repository;

    @Autowired
    private LocalConverter converter;

    public List<Local> findAll() {
        return repository.findAll();
    }

    public Local findById(String codigo) {
        return repository.findById(codigo).orElseThrow(() -> new ObjectNotFoundException("Local não encontrado"));
    }

    public Local insert(LocalDto local) {
        return repository.insert(converter.convertToEntity(local));
    }

    public Local update(LocalDto local) {
        Local localAtualizado = findById(local.getIdLocal());
        BeanUtils.copyProperties(local, localAtualizado);
        return repository.save(localAtualizado);
    }

    public void delete(String codigo) {
        findById(codigo);
        repository.deleteById(codigo);
    }
}
