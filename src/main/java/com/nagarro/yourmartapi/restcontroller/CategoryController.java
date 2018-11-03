package com.nagarro.yourmartapi.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.entity.Category;
import com.nagarro.yourmartapi.repository.CategoryRepository;

@CrossOrigin
@RestController
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/category")
	public List<Category> getAllCategory() {
		return categoryRepository.getAllCategory();
	}
	
	@PostMapping(path = "/category")
	public void addCategory(@RequestBody Category category) {
		categoryRepository.save(category);
	}
}
