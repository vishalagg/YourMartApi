package com.nagarro.yourmartapi.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	public List<Product> getAllProduct(int offset,int limit,String sortBy,String searchKey, String searchQuery, String status, String category) {
		Query query = null;
		boolean isWhereRequired = true;
		String queryString = "SELECT p FROM Product p ";
		
		if(searchKey!=null) {
			String sq = searchKey.equals("name") ? "p.name" : "p.code" ;
			queryString += "WHERE " + sq + " = '" + searchQuery + "' ";
			isWhereRequired = false;
		}
		
		if(status!=null) {
			if(isWhereRequired) {
				queryString += "WHERE p.status = '" + status + "' ";				
				isWhereRequired = false;
			}else {
				queryString += "AND p.status = '" + status + "' ";				
			}
		}
		if(category!=null) {
			if(isWhereRequired) {
				queryString += "WHERE p.category = '" + category + "' ";				
				isWhereRequired = false;
			}else {
				queryString += "AND p.category = '" + category + "' ";				
			}
		}
		if(sortBy!=null) {
			queryString += "ORDER BY "+sortBy;
		}
		query = em.createQuery(queryString);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return (List<Product>)query.getResultList();
	}
	
	@Override
	public Product getProduct(int id) {
		return em.find(Product.class, id);
	}

	@Override
	public Product updateProduct(Product product) {
		return em.merge(product);
	}

	@Override
	public void deleteProduct(int id) {
		Query query = em.createQuery("DELETE FROM Product p WHERE p.id = :id");
		int i = query.setParameter("id", id).executeUpdate();
	}

	@Override
	public ArrayList<Product> getAllProduct(int offset, int limit, String sortBy, String searchKey, String searchQuery,
			String status, String category, String sellerId, String sellerCompanyName) {
		Query query = null;
		boolean isWhereRequired = true;
		String queryString = "SELECT p FROM Product p ";
		
		if(searchKey!=null) {
			String sq = searchKey.equals("name") ? "p.name" : "p.code" ;
			queryString += "WHERE " + sq + " = '" + searchQuery + "' ";
			isWhereRequired = false;
		}
		
		if(status!=null) {
			if(isWhereRequired) {
				queryString += "WHERE p.status = '" + status + "' ";				
				isWhereRequired = false;
			}else {
				queryString += "AND p.status = '" + status + "' ";				
			}
		}
		if(category!=null && !category.equals("null")) {
			if(isWhereRequired) {
				queryString += "WHERE p.category.name = '" + category + "' ";				
				isWhereRequired = false;
			}else {
				queryString += "AND p.category.name = '" + category + "' ";				
			}
		}
		if(sellerId!=null && !sellerId.equals("null")) {
			if(isWhereRequired) {
				queryString += "WHERE p.seller.id = '" + sellerId + "' ";				
				isWhereRequired = false;
			}else {
				queryString += "AND p.seller.id = '" + sellerId + "' ";				
			}
		}
		if(sellerCompanyName!=null && !sellerCompanyName.equals("null")) {
			if(isWhereRequired) {
				queryString += "WHERE p.seller.companyName = '" + sellerCompanyName + "' ";				
				isWhereRequired = false;
			}else {
				queryString += "AND p.seller.companyName = '" + sellerCompanyName + "' ";				
			}
		}
		if(sortBy!=null) {
			queryString += "ORDER BY "+sortBy;
		}
		System.out.println(queryString);
		query = em.createQuery(queryString);
		query.setFirstResult(offset);
		query.setMaxResults(limit);
		return (ArrayList<Product>)query.getResultList();
	}
	
}
