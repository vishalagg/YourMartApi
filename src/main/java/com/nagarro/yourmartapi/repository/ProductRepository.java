package com.nagarro.yourmartapi.repository;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.yourmartapi.entity.Product;

public interface ProductRepository {

	public void save(Product product);

	public List<Product> getAllProduct(int offset,int limit,String sortBy,String searchKey,String searchQuery,String status, String category);

	public Product getProduct(int id);

	public Product updateProduct(Product product);

	public void deleteProduct(int id);

	public ArrayList<Product> getAllProduct(int offset, int limit, String sortBy, String searchKey, String searchQuery,
			String status, String category, String sellerId, String sellerCompanyName);
	
}