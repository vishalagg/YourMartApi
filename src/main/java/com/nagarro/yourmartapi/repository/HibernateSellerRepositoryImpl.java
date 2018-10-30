package com.nagarro.yourmartapi.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.yourmartapi.entity.Seller;

@Repository
@Transactional
public class HibernateSellerRepositoryImpl implements SellerRepository {

	@Autowired
	private EntityManager em;
	
	@Override
	public void save(Seller seller) {
		em.persist(seller);
		
	}
	
	@Override
	public Seller getAllSeller() {
		return em.find(Seller.class, 1);
	}

}
