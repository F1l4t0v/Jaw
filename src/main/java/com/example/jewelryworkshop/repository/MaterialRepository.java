package com.example.jewelryworkshop.repository;

import com.example.jewelryworkshop.model.Material;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialRepository extends MongoRepository<Material, String> {

}
