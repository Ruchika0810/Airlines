package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import org.springframework.ui.ModelMap;

import com.lti.model.BookingDetails;
import com.lti.model.FlightsDetails;

@Repository
public class BookingDetailsRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
	public BookingDetails addBookingDetails(BookingDetails bookingDetails) {
		
		
		BookingDetails details=entityManager.merge(bookingDetails);
		
		return details;
	}

	public BookingDetails cancleTicket(int id) {
		Query q= entityManager.createQuery("select b from BookingDetails b where b.bookingId=:ida");
		q.setParameter("ida", id);

		BookingDetails details =(BookingDetails) q.getSingleResult();

		return details;
		}

}
