package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.AreaModel;
import com.example.demo.services.AreaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/areas")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @GetMapping
    public List<AreaModel> getAllAreas() {
        return areaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AreaModel> getAreaById(@PathVariable Long id) {
        Optional<AreaModel> area = areaService.findById(id);
        return area.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<AreaModel> createArea(@Validated @RequestBody AreaModel area) {
        AreaModel savedArea = areaService.save(area);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedArea);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AreaModel> updateArea(@PathVariable Long id, @Validated @RequestBody AreaModel area) {
        return areaService.findById(id)
                .map(existingArea -> {
                    area.setId(existingArea.getId());
                    AreaModel updatedArea = areaService.save(area);
                    return ResponseEntity.ok().body(updatedArea);
                }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteArea(@PathVariable Long id) {
        return areaService.findById(id)
                .map(existingArea -> {
                    areaService.deleteById(id);
                    return ResponseEntity.noContent().build();
                }).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
