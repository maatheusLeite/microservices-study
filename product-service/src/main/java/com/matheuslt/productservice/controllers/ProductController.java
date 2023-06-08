package com.matheuslt.productservice.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheuslt.productservice.controllers.dtos.ProductDto;
import com.matheuslt.productservice.models.Product;
import com.matheuslt.productservice.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	ProductService service;	
	
	@GetMapping
	public ResponseEntity<Page<Product>> findAll(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		
		return ResponseEntity.status(HttpStatus.OK).body(service.findAll(pageable));
	}
	
	@PostMapping
	public ResponseEntity<Object> save(@RequestBody ProductDto productDto) {
		Product product = new Product();
		BeanUtils.copyProperties(productDto, product);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(product));
	}
}
