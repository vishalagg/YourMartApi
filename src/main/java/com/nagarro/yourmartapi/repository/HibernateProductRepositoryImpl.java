package com.nagarro.yourmartapi.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.yourmartapi.entity.Product;

@Repository
@Transactional
public class HibernateProductRepositoryImpl implements ProductRepository {

	@Autowired
	private EntityManager em;
	
	@Override
	public void save(Product product) {
		System.out.println("Product : " + product.getSeller());
		System.out.println(product.getId());
		em.persist(product);
	}

	@Override
	public Product getAllProduct() {
		return em.find(Product.class, 10);
	}
}
