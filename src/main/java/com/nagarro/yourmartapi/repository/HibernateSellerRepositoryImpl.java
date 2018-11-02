package com.nagarro.yourmartapi.repository;

import java.util.ArrayList;
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
	public List<Seller> getAllSeller(int offset,int limit,String sortBy,String filter,String searchKey,String searchQuery) {
		boolean isWhereRequired = true;
		String queryString = "SELECT s FROM Seller s ";
		
		if(searchKey!=null) {
			String sq = searchKey.equals("COMPANY_NAME") ? "s.companyName" : (searchKey.equals("OWNER_NAME")?"s.ownerName":"s.phone");
			queryString += "WHERE " + sq + " LIKE '%" + searchQuery + "%' ";
			isWhereRequired = false;
		}
		
		if(filter!=null) {
			int filterBy = filter.equals("NEED_APPROVAL")? 1 : (filter.equals("APPROVED")?2:3);
			if(isWhereRequired) {
				queryString += "WHERE s.statusId = " + filterBy + " ";				
				isWhereRequired = false;
			}else {
				queryString += "AND s.statusId = " + filterBy + " ";				
			}
		}
		
		queryString += "ORDER BY "+sortBy;
		System.out.println(queryString);
//		String queryString = "SELECT s FROM Seller s ORDER BY " + sortBy;
		Query query = em.createQuery(queryString);
		query.setFirstResult(offset);
		query.setMaxResults(limit);			
		return (List<Seller>)query.getResultList();
	}

	@Override
	public Seller authenticate(int sellerId, String password) {
		String queryString = "SELECT s FROM Seller s WHERE s.id = '" + sellerId + "' AND s.password = '" + password + "'";
		Query query = em.createQuery(queryString);
		Seller result;
		try {
			result = (Seller) query.getSingleResult();			
		}catch(Exception e) {
			result = null;
		}
		return result;
	}

	@Override
	public void setStatus(String id, int i) {
		String queryString = "UPDATE Seller s SET s.statusId = " + i +" WHERE s.id = " + id;
		Query query = em.createQuery(queryString);
		int numRows = query.executeUpdate();
	}

	@Override
	public ArrayList<Integer> getAllSellerId() {
		String queryString = "SELECT s.id FROM Seller s";
		return (ArrayList<Integer>) em.createQuery(queryString).getResultList();
	}

	@Override
	public ArrayList<String> getAllSellerCampanyName() {
		String queryString = "SELECT s.companyName FROM Seller s";
		return (ArrayList<String>) em.createQuery(queryString).getResultList();
	}

	@Override
	public Seller getSeller(int id) {
		return em.find(Seller.class, id);
	}

}
