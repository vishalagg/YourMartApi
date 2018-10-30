package com.nagarro.yourmartapi.repository;

import com.nagarro.yourmartapi.entity.Seller;

public interface SellerRepository {
	
	void save(Seller seller);
	Seller getAllSeller();

}