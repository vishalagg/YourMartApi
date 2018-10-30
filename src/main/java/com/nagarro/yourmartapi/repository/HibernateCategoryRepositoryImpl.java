package com.nagarro.yourmartapi.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nagarro.yourmartapi.entity.Category;

@Repository
@Transactional
public class HibernateCategoryRepositoryImpl implements CategoryRepository{

	@Autowired
	private EntityManager em;
	
	@Override
	public List<Category> getAllCategory() {
		Query query = em.createQuery("SELECT c FROM Category c");
		return (List<Category>)query.getResultList();
	}

	@Override
	public void save(Category category) {
		em.persist(category);
	}

}
