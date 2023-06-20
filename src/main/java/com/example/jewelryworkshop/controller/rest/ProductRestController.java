package com.example.jewelryworkshop.controller.rest;

import com.example.jewelryworkshop.model.Bill;
import com.example.jewelryworkshop.model.Product;
import com.example.jewelryworkshop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public List<Product> getAll(){
        return productService.getAll();
    }
    @GetMapping("/{id}")
    public Product getOne(@PathVariable String id){
        return productService.getOne(id);
    }

    @PostMapping("/")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PutMapping("/")
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id){
        productService.delete(id);
    }
}
