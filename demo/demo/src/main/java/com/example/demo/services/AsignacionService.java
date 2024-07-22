package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AsignacionModel;
import com.example.demo.repositories.AsignacionRepository;

@Service
public class AsignacionService {
    @Autowired
    private AsignacionRepository asignacionRepository;

    public List<AsignacionModel> findAll() {
        return (List<AsignacionModel>) asignacionRepository.findAll();
    }

    public AsignacionModel guardarAsignacion(AsignacionModel asignacion) {
        return asignacionRepository.save(asignacion);
    }

    public Optional<AsignacionModel> findById(Long id) {
        return asignacionRepository.findById(id);
    }

    public void deleteById(Long id) {
        asignacionRepository.deleteById(id);
    }
    
}
