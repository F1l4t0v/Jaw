package com.example.jewelryworkshop.service.interfaces;

import com.example.jewelryworkshop.model.Bill;

import java.util.List;

public interface BillService {
    List<Bill> getAll();
    Bill getOne(String id);
    Bill create(Bill bill);
    Bill update(Bill bill);
    void delete(String id);
}
