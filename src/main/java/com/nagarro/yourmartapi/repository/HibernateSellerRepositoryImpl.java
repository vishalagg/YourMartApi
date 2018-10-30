package com.nagarro.yourmartapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	public List<Seller> getAllSeller(int offset,int limit) {
		Query query = em.createQuery("SELECT s FROM Seller s ORDER BY statusId");
		query.setFirstResult(offset);
		query.setMaxResults(limit);			
		return (List<Seller>)query.getResultList();
	}

}
