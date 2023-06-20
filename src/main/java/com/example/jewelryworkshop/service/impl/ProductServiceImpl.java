package com.example.jewelryworkshop.service.impl;

import com.example.jewelryworkshop.model.Bill;
import com.example.jewelryworkshop.model.Material;
import com.example.jewelryworkshop.model.Product;
import com.example.jewelryworkshop.model.enums.Materialu;
import com.example.jewelryworkshop.repository.ProductRepository;
import com.example.jewelryworkshop.service.interfaces.MaterialService;
import com.example.jewelryworkshop.service.interfaces.ProductService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.DoubleStream;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository repository;

    @Autowired
    MaterialService materialService;

    //@PostConstruct
    void init(){
        List<Materialu> myList = Arrays.asList(Materialu.GOLD, Materialu.SILVER);
        Map<Materialu, Double> myMap = new HashMap<>();
        myMap.put(Materialu.GOLD, 110.0);
        myMap.put(Materialu.SILVER, 49.0);
        repository.save(new Product("Кольцо", "Золото", myList, myMap,
                setPrice(myList, myMap)));
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Product create(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        return repository.save(product);
    }

    @Override
    public Product update(Product product) {
        String id = product.getId();
        Product product1 = this.getOne(id);
        product.setCreatedAt(product1.getCreatedAt());
        product.setUpdatedAt(LocalDateTime.now());
        return repository.save(product);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
    public Material getMaterial(Product product){
        if(product.getMaterials().contains(Materialu.GOLD)){
            return materialService.getOne("648caac7c0439208ef25a72b");
        }
        if(product.getMaterials().contains(Materialu.SILVER)){
            return materialService.getOne("648caac7c0439208ef25a72b");
        }
        else {
            return null;
        }
    }
    public double setPrice(List<Materialu> materialus, Map<Materialu, Double> weight){
        double sum = materialus.stream()
                .flatMapToDouble(item -> {
                    if (weight.containsKey(item)) {
                        return DoubleStream.of(weight.get(item));
                    } else {
                        return DoubleStream.empty();
                    }
                })
                .sum();

        return sum;
    }
    public Product setWeight(Product product, Double weight, Map<Materialu, Double> map){
        map.put(Materialu.GOLD, weight);
        return product;
    }
}
