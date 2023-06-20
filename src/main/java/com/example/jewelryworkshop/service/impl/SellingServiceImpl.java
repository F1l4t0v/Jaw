package com.example.jewelryworkshop.service.impl;

import com.example.jewelryworkshop.model.Bill;
import com.example.jewelryworkshop.model.Selling;
import com.example.jewelryworkshop.repository.SellingRepository;
import com.example.jewelryworkshop.service.interfaces.ClientService;
import com.example.jewelryworkshop.service.interfaces.ProductService;
import com.example.jewelryworkshop.service.interfaces.SellingService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class SellingServiceImpl implements SellingService {
    @Autowired
    SellingRepository repository;

    @Autowired
    ProductService productService;

    @Autowired
    ClientService clientService;

    //@PostConstruct
    void init(){
        repository.save(new Selling(productService.getOne("648ca206e8f3e100437db57b"),
                LocalDateTime.now(), clientService.getOne("6491492dd65cd243a4b388da")));
    }

    @Override
    public List<Selling> getAll() {
        return repository.findAll();
    }

    @Override
    public Selling getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Selling create(Selling selling) {
        selling.setCreatedAt(LocalDateTime.now());
        return repository.save(selling);
    }

    @Override
    public Selling update(Selling selling) {
        String id = selling.getId();
        Selling selling1 = this.getOne(id);
        selling.setCreatedAt(selling1.getCreatedAt());
        selling.setUpdatedAt(LocalDateTime.now());
        return repository.save(selling);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
