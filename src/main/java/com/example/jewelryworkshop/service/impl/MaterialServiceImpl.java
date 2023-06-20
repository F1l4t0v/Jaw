package com.example.jewelryworkshop.service.impl;

import com.example.jewelryworkshop.model.Bill;
import com.example.jewelryworkshop.model.Material;
import com.example.jewelryworkshop.repository.MaterialRepository;
import com.example.jewelryworkshop.service.interfaces.MaterialService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class MaterialServiceImpl implements MaterialService {
    @Autowired
    MaterialRepository repository;

    //@PostConstruct
    void init(){
        repository.save(new Material("GOLD", 110));
    }

    @Override
    public List<Material> getAll() {
        return repository.findAll();
    }

    @Override
    public Material getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Material create(Material material) {
        material.setCreatedAt(LocalDateTime.now());
        return repository.save(material);
    }

    @Override
    public Material update(Material material) {
        String id = material.getId();
        Material material1 = this.getOne(id);
        material.setCreatedAt(material1.getCreatedAt());
        material.setUpdatedAt(LocalDateTime.now());
        return repository.save(material);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
