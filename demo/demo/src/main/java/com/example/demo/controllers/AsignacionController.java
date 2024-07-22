package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.AsignacionModel;
import com.example.demo.services.AsignacionService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asignaciones")
public class AsignacionController {
    @Autowired
    private AsignacionService asignacionService;

    @GetMapping
    public List<AsignacionModel> getAllAsignaciones() {
        return asignacionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionModel> getAsignacionById(@PathVariable Long id) {
        Optional<AsignacionModel> asignacion = asignacionService.findById(id);
        return asignacion.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<AsignacionModel> createAsignacion(@Validated @RequestBody AsignacionModel asignacion) {
        AsignacionModel savedAsignacion = asignacionService.guardarAsignacion(asignacion);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAsignacion);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AsignacionModel> actualizarAsignacion(@PathVariable Long id, @Validated @RequestBody AsignacionModel asignacion) {
        System.out.println("ID recibido: " + id);
        System.out.println("Datos recibidos para actualización: " + asignacion);
        return asignacionService.findById(id)
                .map(existingAsignacion -> {
                    asignacion.setId(existingAsignacion.getId());
                    AsignacionModel updatedAsignacion = asignacionService.guardarAsignacion(asignacion);
                    System.out.println("Datos actualizados: " + updatedAsignacion);
                    return ResponseEntity.ok().body(updatedAsignacion);
                }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAsignacion(@PathVariable Long id) {
        return asignacionService.findById(id)
                .map(existingAsignacion -> {
                    asignacionService.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}

