package com.example.jewelryworkshop.service.interfaces;

import com.example.jewelryworkshop.model.Material;

import java.util.List;

public interface MaterialService {
    List<Material> getAll();
    Material getOne(String id);
    Material create(Material material);
    Material update(Material material);
    void delete(String id);
}
