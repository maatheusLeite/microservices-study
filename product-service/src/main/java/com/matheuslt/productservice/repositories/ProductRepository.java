package com.matheuslt.productservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.matheuslt.productservice.models.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
