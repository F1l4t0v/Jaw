package com.example.jewelryworkshop.service.impl;

import com.example.jewelryworkshop.model.Bill;
import com.example.jewelryworkshop.model.Client;
import com.example.jewelryworkshop.model.Product;
import com.example.jewelryworkshop.model.enums.Regular;
import com.example.jewelryworkshop.repository.BillRepository;
import com.example.jewelryworkshop.service.interfaces.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository repository;

    @Autowired
    ClientService clientService;

    @Autowired
    SellingService sellingService;

    @Autowired
    ProductService productService;

    @Autowired
    MaterialService materialService;

    //@PostConstruct
    void init(){
        repository.save(new Bill(clientService.getOne("6491492dd65cd243a4b388da"),
                sellingService.getOne("64914b62eae2bb6709d9ec91"),
                productService.getAll(),
                materialService.getOne("64914be80fe03b28e83e7ac7"),
                this.getTotalDiscount(clientService.getOne("6491492dd65cd243a4b388da"),
                        productService.getAll()),
                this.getTotalSum(clientService.getOne("6491492dd65cd243a4b388da"),
                        productService.getAll())));
    }

    @Override
    public List<Bill> getAll() {
        return repository.findAll();
    }

    @Override
    public Bill getOne(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Bill create(Bill bill) {
        bill.setCreatedAt(LocalDateTime.now());
        return repository.save(bill);
    }

    @Override
    public Bill update(Bill bill) {
        String id = bill.getId();
        Bill bill1 = this.getOne(id);
        bill.setCreatedAt(bill1.getCreatedAt());
        bill.setUpdatedAt(LocalDateTime.now());
        return repository.save(bill);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    private double getTotalDiscount(Client client, List<Product> products){
        double discount1 = 0.0;
        double discount2 = 0.0;
        if(client.getClientStatus() == Regular.REGULAR){
            discount1 = 0.2;
        }
        if(products.stream().mapToDouble(Product::getPrice).sum() > 1000){
            discount2 = 0.2;
        }
        return discount1 + discount2;
    }
    private double getTotalSum(Client client, List<Product> products){
        double suma = products.stream().mapToDouble(Product::getPrice).sum();
        return suma - suma * this.getTotalDiscount(client, products);
    }
    public void getBill(Client client, List<Product> products){
        Bill bill = new Bill();
        bill.setClient(client);
        double discount1 = 0.0;
        double discount2 = 0.0;
        if(client.getClientStatus() == Regular.REGULAR){
            discount1 = 0.2;
        }
        if(products.stream().mapToDouble(Product::getPrice).sum() > 1000){
            discount2 = 0.2;
        }
        bill.setDiscount(this.getTotalDiscount(client, products));
        bill.setTotalPrice(this.getTotalSum(client, products));
    }
}
