package com.nagarro.yourmartapi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.yourmartapi.entity.Category;
import com.nagarro.yourmartapi.entity.Product;
import com.nagarro.yourmartapi.enums.ProductStatus;
import com.nagarro.yourmartapi.repository.CategoryRepository;
import com.nagarro.yourmartapi.repository.ProductRepository;
import com.nagarro.yourmartapi.repository.SellerRepository;

@Controller
public class AdminPanelProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@RequestMapping(value="/admin/product",method = RequestMethod.GET)
	public String getAllProduct(Model model,HttpServletRequest request,HttpServletResponse response, 
								@RequestParam(value="status",required = false) String status, 
								@RequestParam(value="searchQuery",required = false) String searchQuery,
								@RequestParam(value="searchKey",required = false) String searchKey,
								@RequestParam(value="sortBy",required=false) String sortBy,
								@RequestParam(value="category",required=false) String category,
								@RequestParam(value="sellerId",required=false) String sellerId,
								@RequestParam(value="sellerCompanyName",required=false) String sellerCompanyName){
		
		HttpSession session = request.getSession(false);
		int productStatus = -1;
		model.addAttribute("searchQuery", searchQuery);
		if(searchKey!=null) {
			String codeSelected = searchKey.equals("code") ? "selected" : " "; 
			model.addAttribute("codeSelected", codeSelected);
			String nameSelected = searchKey.equals("name") ? "selected" : " "; 
			model.addAttribute("nameSelected", nameSelected);
			String idSelected = searchKey.equals("id") ? "selected" : " "; 
			model.addAttribute("idSelected", idSelected);
		}
		if(sortBy!=null) {
			String mrpChecked = sortBy.equals("mrp") ? "checked" : " "; 
			model.addAttribute("mrpChecked", mrpChecked);
			String sspChecked = sortBy.equals("ssp") ? "checked" : " "; 
			model.addAttribute("sspChecked", sspChecked);
			String ympChecked = sortBy.equals("ymp") ? "checked" : " "; 
			model.addAttribute("ympChecked", ympChecked);
			String createdAtChecked = sortBy.equals("createdAt") ? "checked" : " "; 
			model.addAttribute("createdAtChecked", createdAtChecked);
			String updatedAtChecked = sortBy.equals("updatedAt") ? "checked" : " "; 
			model.addAttribute("updatedAtChecked", updatedAtChecked);
			
		}
		if(status!=null) {
//			productStatus = ProductStatus.valueOf(status).ordinal();
			productStatus = 1;
			String newChecked = status.equals("NEW") ? "checked" : " "; 
			model.addAttribute("newChecked", newChecked);
			String approvedChecked = status.equals("APPROVED") ? "checked" : " "; 
			model.addAttribute("approvedChecked", approvedChecked);
			String reviewChecked = status.equals("REVIEW") ? "checked" : " "; 
			model.addAttribute("reviewChecked", reviewChecked);
			String rejectedChecked = status.equals("REJECTED") ? "checked" : " "; 
			model.addAttribute("rejectedChecked", rejectedChecked);
		}
		if(session!=null && session.getAttribute("admin")!=null) {
			int offset = 0;
			int limit = 10;
			ArrayList<Product> products = new ArrayList<>();
			ArrayList<Integer> sellerIds = new ArrayList<>();
			ArrayList<String> sellerCompanyNames = new ArrayList<>();
			ArrayList<Category> categories = new ArrayList<>();
			System.out.println(searchKey + " kkk "+ searchQuery);
			products = (ArrayList<Product>) productRepository.getAllProduct(offset, limit, sortBy, searchKey, searchQuery, productStatus, category,sellerId,sellerCompanyName);
			sellerIds = (ArrayList<Integer>) sellerRepository.getAllSellerId();
			sellerCompanyNames = (ArrayList<String>) sellerRepository.getAllSellerCampanyName();
			categories = (ArrayList<Category>) categoryRepository.getAllCategory();
			model.addAttribute("products", products);
			model.addAttribute("sellerIds", sellerIds);
			model.addAttribute("sellerCompanyNames", sellerCompanyNames);
			model.addAttribute("categories", categories);
			return "product";
		}
		return "redirect:/admin/login";
	}
	
	@RequestMapping(value="/admin/product",method = RequestMethod.POST)
	public String homePage(HttpServletRequest request, HttpServletResponse response) {
		String[] ids = request.getParameterValues("cbox");
		if(ids!=null) {
			for(String value : ids) {
				System.out.println(value);
				// 1=>NEED_APPROVAL 2=>APPROVED 3=>REJECTED
				productRepository.setStatus(value,ProductStatus.APPROVED.ordinal()+1,"");
			}			
		}
		return "redirect:/admin/product";
	}
	
	@RequestMapping(value="/admin/product/{productId}", method = RequestMethod.GET)
	public String productDetailsPage(HttpServletRequest request, HttpServletResponse response,
									@PathVariable("productId") int id, ModelMap model,
									@RequestParam(value="status",required = false) String status,
									@RequestParam(value="comment",required = false) String comment) {
		if(status!=null) {
			int intStatus = Integer.parseInt(status);
			if(intStatus==4 && comment.isEmpty()) {
				model.addAttribute("commentError", "**please write comment");
			}else {
				productRepository.setStatus(id+"", intStatus,comment);				
			}
		}
		Product product = productRepository.getProduct(id);
		model.addAttribute("product", product);
		return "productDetails";
	}

}
