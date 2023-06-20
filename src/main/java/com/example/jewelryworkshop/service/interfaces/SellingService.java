package com.example.jewelryworkshop.service.interfaces;

import com.example.jewelryworkshop.model.Selling;

import java.util.List;

public interface SellingService {
    List<Selling> getAll();
    Selling getOne(String id);
    Selling create(Selling selling);
    Selling update(Selling selling);
    void delete(String id);
}
