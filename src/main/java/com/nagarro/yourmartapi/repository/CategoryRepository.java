package com.nagarro.yourmartapi.repository;

import java.util.List;

import com.nagarro.yourmartapi.entity.Category;

public interface CategoryRepository {

	public List<Category> getAllCategory(); 
	public void save(Category category); 
}
