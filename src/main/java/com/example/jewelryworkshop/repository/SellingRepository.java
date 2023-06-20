package com.example.jewelryworkshop.repository;

import com.example.jewelryworkshop.model.Selling;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellingRepository extends MongoRepository<Selling, String> {

}
