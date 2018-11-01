package com.nagarro.yourmartapi.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.yourmartapi.entity.Product;
import com.nagarro.yourmartapi.entity.Seller;
import com.nagarro.yourmartapi.repository.ProductRepository;
import com.nagarro.yourmartapi.repository.SellerRepository;

@Controller
public class AdminPanelProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private SellerRepository sellerRepository;

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
		model.addAttribute("searchQuery", searchQuery);
		if(searchKey!=null) {
			String codeChecked = searchKey.equals("code") ? "checked" : " "; 
			model.addAttribute("codeChecked", codeChecked);
			String nameChecked = searchKey.equals("name") ? "checked" : " "; 
			model.addAttribute("nameChecked", nameChecked);
			String idChecked = searchKey.equals("id") ? "checked" : " "; 
			model.addAttribute("idChecked", idChecked);
		}
		if(sortBy!=null) {
			String idChecked = sortBy.equals("id") ? "checked" : " "; 
			model.addAttribute("idChecked", idChecked);
			String createdAtChecked = sortBy.equals("createdAt") ? "checked" : " "; 
			model.addAttribute("createdAtChecked", createdAtChecked);
			
		}
		if(status!=null) {
			String needApprovalChecked = status.equals("NEED_APPROVAL") ? "checked" : " "; 
			model.addAttribute("needApprovalChecked", needApprovalChecked);
			String approvedChecked = status.equals("APPROVED") ? "checked" : " "; 
			model.addAttribute("approvedChecked", approvedChecked);
			String rejectedChecked = status.equals("REJECTED") ? "checked" : " "; 
			model.addAttribute("rejectedChecked", rejectedChecked);
		}
		if(session!=null && session.getAttribute("admin")!=null) {
			int offset = 0;
			int limit = 10;
			ArrayList<Product> products = new ArrayList<>();
			ArrayList<Integer> sellerIds = new ArrayList<>();
			ArrayList<String> sellerCompanyNames = new ArrayList<>();
			products = (ArrayList<Product>) productRepository.getAllProduct(offset, limit, sortBy, searchKey, searchQuery, status, category,sellerId,sellerCompanyName);
			sellerIds = (ArrayList<Integer>) sellerRepository.getAllSellerId();
			sellerCompanyNames = (ArrayList<String>) sellerRepository.getAllSellerCampanyName();
			model.addAttribute("products", products);
			model.addAttribute("sellerIds", sellerIds);
			model.addAttribute("sellerCompanyNames", sellerCompanyNames);
			return "product";
		}
		return "redirect:/admin/login";
	}


}
