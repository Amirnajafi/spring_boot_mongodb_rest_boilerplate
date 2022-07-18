package com.amir.test.products;

import com.amir.test.models.Products;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Products, String> {
//    Optional<Products> findById(String id);

    Boolean existsById(Id id);

}