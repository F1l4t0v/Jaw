package com.example.jewelryworkshop.service.interfaces;


import com.example.jewelryworkshop.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getOne(String id);
    Product create(Product product);
    Product update(Product product);
    void delete(String id);
}
