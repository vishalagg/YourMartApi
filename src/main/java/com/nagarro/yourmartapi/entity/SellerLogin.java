//package com.nagarro.yourmartapi.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
//@Entity
//public class SellerLogin {
//
//	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
//	private int id;
//	
//	@OneToOne
//	private int sellerId;
//	
//	private String password;
//	private String token;
//	
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getToken() {
//		return token;
//	}
//	public void setToken(String token) {
//		this.token = token;
//	}
//	public int getId() {
//		return id;
//	}
//}
