package com.matheuslt.productservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.matheuslt.productservice.models.Product;
import com.matheuslt.productservice.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository repository;
	
	public Product save(Product product) {
		return repository.save(product);
	}

	public Page<Product> findAll(Pageable pageable) {
		return repository.findAll(pageable);
	}
}
