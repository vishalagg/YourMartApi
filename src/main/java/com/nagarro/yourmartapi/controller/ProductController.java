package com.nagarro.yourmartapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.entity.Product;
import com.nagarro.yourmartapi.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/product")
	public Product getAllSeller() {
		return productRepository.getAllProduct();
	}
	
	@PostMapping(path = "/product")
	public void addSeller(@RequestBody Product product) {
		System.out.println(product);
		productRepository.save(product);
	}
}
