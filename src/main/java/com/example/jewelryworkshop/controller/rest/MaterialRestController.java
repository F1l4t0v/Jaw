package com.example.jewelryworkshop.controller.rest;

import com.example.jewelryworkshop.model.Material;
import com.example.jewelryworkshop.service.interfaces.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/materials")
public class MaterialRestController {
    @Autowired
    MaterialService materialService;

    @GetMapping("/")
    public List<Material> getAll(){
        return materialService.getAll();
    }
    @GetMapping("/{id}")
    public Material getOne(@PathVariable String id){
        return materialService.getOne(id);
    }

    @PostMapping("/")
    public Material create(@RequestBody Material material){
        return materialService.create(material);
    }

    @PutMapping("/")
    public Material update(@RequestBody Material material){
        return materialService.update(material);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        materialService.delete(id);
    }
}
