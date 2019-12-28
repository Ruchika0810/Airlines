package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.BookingDetails;

@Repository
public class BookingHistoryRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	public List<BookingDetails> viewBookingDetails(int id) {
		
	Query q=entityManager.createQuery("select distinct b from BookingDetails b join fetch b.passenger join fetch b.payment where b.registeration.registerationId=:rid");
	q.setParameter("rid",id);
	return q.getResultList();
	 
}
}
