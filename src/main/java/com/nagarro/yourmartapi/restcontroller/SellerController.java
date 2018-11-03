package com.nagarro.yourmartapi.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.yourmartapi.dto.SellerLoginResponse;
import com.nagarro.yourmartapi.entity.Seller;
import com.nagarro.yourmartapi.enums.SellerStatus;
import com.nagarro.yourmartapi.exceptions.BaseException;
import com.nagarro.yourmartapi.exceptions.InvalidCredentialException;
import com.nagarro.yourmartapi.exceptions.UnexpectedError;
import com.nagarro.yourmartapi.model.SellerLogin;
import com.nagarro.yourmartapi.repository.SellerRepository;
import com.nagarro.yourmartapi.util.Utility;

@CrossOrigin
@RestController
public class SellerController {

	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	SellerLoginResponse sellerLoginResponse;
	
	@PostMapping(path = "/seller/register")
	public void addSeller(@RequestBody Seller seller) {
		try {
			seller.setStatusId(SellerStatus.NEED_APPROVAL.ordinal()+1);
			sellerRepository.save(seller);			
		}catch(Exception ex) {
			throw new UnexpectedError();
		}		
	}
	@PostMapping(path="/seller/login")
	public ResponseEntity login(@RequestBody SellerLogin sellerLogin) {
		Seller seller = sellerRepository.authenticate(sellerLogin.getid(),sellerLogin.getPassword());
		if(seller==null) {
			throw new InvalidCredentialException();
		}
		sellerLoginResponse = Utility.convertModel(seller, SellerLoginResponse.class);			
		return ResponseEntity.status(200).body(sellerLoginResponse);			
	}
}
