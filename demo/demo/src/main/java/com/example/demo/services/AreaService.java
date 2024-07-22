package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.AreaModel;
import com.example.demo.repositories.AreaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AreaService {

        @Autowired
    private AreaRepository areaRepository;

    public List<AreaModel> findAll() {
        return (List<AreaModel>) areaRepository.findAll();
    }

    public AreaModel save(AreaModel area) {
        return areaRepository.save(area);
    }

    public Optional<AreaModel> findById(Long id) {
        return areaRepository.findById(id);
    }

    public void deleteById(Long id) {
        areaRepository.deleteById(id);
    }
    
}
