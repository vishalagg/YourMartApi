package com.nagarro.yourmartapi.repository;

import com.nagarro.yourmartapi.entity.Product;

public interface ProductRepository {

	public void save(Product product);

	public Product getAllProduct();
}