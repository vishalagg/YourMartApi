package com.nagarro.yourmartapi.repository;

import java.util.ArrayList;
import java.util.List;

import com.nagarro.yourmartapi.entity.Seller;
import com.nagarro.yourmartapi.entity.SellerCredentials;

public interface SellerRepository {
	
	int save(SellerCredentials sellerCredentials);
	List<Seller> getAllSeller(int offset,int limit,String sortBy, String filter,String searchKey,String searchQuery);
	Seller authenticate(int sellerId, String password);
	void setStatus(int value, String status);
	ArrayList<Integer> getAllSellerId();
	ArrayList<String> getAllSellerCampanyName();
	Seller getSeller(int id);
	Boolean isAuthenticatedByToken(int id, String token);
	Long totalSeller();

}