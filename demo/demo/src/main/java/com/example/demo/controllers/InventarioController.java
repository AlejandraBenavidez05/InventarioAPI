package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.InventarioModel;
import com.example.demo.services.InventarioService;

@RestController
@RequestMapping("/activo")
public class InventarioController {

    @Autowired
    InventarioService inventarioService;

    @GetMapping()
    public ArrayList<InventarioModel> obtenerInventario() {
        return inventarioService.obtenerInventario();
    }

    @PostMapping
    public InventarioModel guardarInventario(@RequestBody InventarioModel inventario) {
        return this.inventarioService.guardarActivo(inventario);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventarioModel> obtenerInventarioPorId(@PathVariable Long id) {
        Optional<InventarioModel> inventario = inventarioService.obtenerPorId(id);
        return inventario.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<InventarioModel> actualizarInventario(@PathVariable Long id, @Validated @RequestBody InventarioModel inventario) {
        return inventarioService.obtenerPorId(id)
                .map(existingInventario -> {
                    inventario.setId(existingInventario.getId());
                    InventarioModel updatedInventario = inventarioService.guardarActivo(inventario);
                    return ResponseEntity.ok().body(updatedInventario);
                }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminarInventario(@PathVariable Long id) {
        return inventarioService.obtenerPorId(id)
                .map(existingInventario -> {
                    inventarioService.eliminarActivo(id);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}

