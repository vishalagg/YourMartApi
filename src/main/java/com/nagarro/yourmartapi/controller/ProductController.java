package com.nagarro.yourmartapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.entity.Product;
import com.nagarro.yourmartapi.entity.Seller;
import com.nagarro.yourmartapi.repository.ProductRepository;

@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/product")
	public List<Product> getAllSeller() {
		return productRepository.getAllProduct();
	}
	
	@PostMapping(path = "/product")
	public void addSeller(@RequestBody Product product) {
		System.out.println(product);
		productRepository.save(product);
	}
	
	@GetMapping(path="/product/{id}")
	public Product getProductById(@PathVariable("id") int id) {
		return productRepository.getProduct(id);
	}
	
	@PutMapping(path="/product/{id}")
	public Product updateProduct(@PathVariable("id") int id,@RequestBody Product product) {
		return productRepository.updateProduct(product);
	}
	
	@DeleteMapping(path="/product/{id}")
	public void deleteProduct(@PathVariable("id") int id) {
		productRepository.deleteProduct(id);
	}
}
