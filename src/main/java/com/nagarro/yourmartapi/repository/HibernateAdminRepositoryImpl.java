package com.nagarro.yourmartapi.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.entity.Admin;

@Repository
public class HibernateAdminRepositoryImpl implements AdminRepository{

	@Autowired
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.nagarro.yourmartapi.repository.AdminRepository#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public Admin authenticate(String username, String password) {
		String queryString = "SELECT a FROM Admin a WHERE a.username = '" + username + "' AND a.password = '" + password + "'";
		Query query = em.createQuery(queryString);
		Admin result = (Admin) query.getSingleResult();
		return result;
	} 
}
