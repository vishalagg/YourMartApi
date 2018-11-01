package com.nagarro.yourmartapi.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.yourmartapi.entity.Category;
import com.nagarro.yourmartapi.repository.CategoryRepository;

@Controller
public class AdminPanelCategoryController {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value="/admin/category",method=RequestMethod.GET)
	public String getAllCategories(Model model) {
		List<Category> categories = categoryRepository.getAllCategory();
		model.addAttribute("categories", categories);
		return "category";
	}
}
