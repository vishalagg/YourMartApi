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

import com.nagarro.yourmartapi.entity.Seller;
import com.nagarro.yourmartapi.repository.SellerRepository;

@Controller
public class AdminPanelSellerController {

	@Autowired
	private SellerRepository sellerRepository;
	
	@RequestMapping(value="/admin/seller",method = RequestMethod.POST)
	public String getAllSeller(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(false);
		if(session!=null && session.getAttribute("admin")!=null) {
			int offset = 0;
			int limit = 10;
			ArrayList<Seller> sellers = new ArrayList<>();
			sellers = (ArrayList<Seller>) sellerRepository.getAllSeller(offset, limit);
			model.addAttribute("sellers", sellers);
			return "seller";
		}
		return "redirect:/admin/login";
	}
}
