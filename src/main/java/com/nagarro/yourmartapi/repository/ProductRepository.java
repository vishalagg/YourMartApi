package com.nagarro.yourmartapi.repository;

import java.util.List;

import com.nagarro.yourmartapi.entity.Product;

public interface ProductRepository {

	public void save(Product product);

	public List<Product> getAllProduct();

	public Product getProduct(int id);

	public Product updateProduct(Product product);

	public void deleteProduct(int id);
}