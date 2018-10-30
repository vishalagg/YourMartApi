package com.nagarro.yourmartapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.entity.Seller;
import com.nagarro.yourmartapi.repository.SellerRepository;

@RestController
public class SellerController {

	@Autowired
	private SellerRepository sellerRepository;
	
	@GetMapping("/seller")
	public Seller getAllSeller() {
		return sellerRepository.getAllSeller();
	}
	
	@PostMapping(path = "/seller")
	public void addSeller(@RequestBody Seller seller) {
		System.out.println(seller);
		sellerRepository.save(seller);
	}
}
