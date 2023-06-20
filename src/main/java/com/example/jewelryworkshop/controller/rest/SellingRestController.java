package com.example.jewelryworkshop.controller.rest;

import com.example.jewelryworkshop.model.Bill;
import com.example.jewelryworkshop.model.Selling;
import com.example.jewelryworkshop.service.interfaces.SellingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class SellingRestController {
    @Autowired
    SellingService sellingService;

    @GetMapping("/")
    public List<Selling> getAll(){
        return sellingService.getAll();
    }
    @GetMapping("/{id}")
    public Selling getOne(@PathVariable String id){
        return sellingService.getOne(id);
    }

    @PostMapping("/")
    public Selling create(@RequestBody Selling selling){
        return sellingService.create(selling);
    }

    @PutMapping("/")
    public Selling update(@RequestBody Selling selling){
        return sellingService.update(selling);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        sellingService.delete(id);
    }
}
