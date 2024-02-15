package com.endlessinnovations.productservice.repository;

import com.endlessinnovations.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String>{
}
