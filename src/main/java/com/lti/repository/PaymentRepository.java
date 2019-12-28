package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.model.BookingDetails;
import com.lti.model.Payment;

@Repository
@Component("pay")
public class PaymentRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addPayment(Payment payment) {
		entityManager.persist(payment);
	}

}
