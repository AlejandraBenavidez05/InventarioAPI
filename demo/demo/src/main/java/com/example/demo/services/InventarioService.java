package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.InventarioModel;
import com.example.demo.repositories.InventarioRepository;

@Service
public class InventarioService {

    @Autowired
    InventarioRepository inventarioRepository;

    public ArrayList<InventarioModel> obtenerInventario() {
        return (ArrayList<InventarioModel>) inventarioRepository.findAll();
    }

    public InventarioModel guardarActivo(InventarioModel inventario) {
        return inventarioRepository.save(inventario);
    }

    public Optional<InventarioModel> obtenerPorId(Long id) {
        return inventarioRepository.findById(id);
    }

    public boolean eliminarActivo(Long id) {
        try {
            inventarioRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
