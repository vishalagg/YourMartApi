package com.nagarro.yourmartapi.repository;

import java.util.List;

import com.nagarro.yourmartapi.entity.Seller;

public interface SellerRepository {
	
	void save(Seller seller);
	List<Seller> getAllSeller(int offset,int limit);

}