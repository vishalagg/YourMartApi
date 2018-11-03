package com.nagarro.yourmartapi.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nagarro.yourmartapi.entity.Image;

@Repository
public class HibernateImageRepositoryImpl implements ImageRepository {

	@Autowired
	private EntityManager em;
	
	/* (non-Javadoc)
	 * @see com.nagarro.yourmartapi.repository.ImageRepository#getImages(int)
	 */
	@Override
	public List<Image> getImages(int productId) {
		Query query = em.createQuery("SELECT i FROM Image i WHERE i.product.id = '" + productId + "'");
		return (List<Image>)query.getResultList();
	}
	
	/* (non-Javadoc)
	 * @see com.nagarro.yourmartapi.repository.ImageRepository#save(com.nagarro.yourmartapi.entity.Image)
	 */
	@Override
	public void save(Image image) {
		em.persist(image);
	}
}
