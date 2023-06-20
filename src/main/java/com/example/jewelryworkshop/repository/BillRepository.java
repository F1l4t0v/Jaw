package com.example.jewelryworkshop.repository;

import com.example.jewelryworkshop.model.Bill;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends MongoRepository<Bill, String> {

}
