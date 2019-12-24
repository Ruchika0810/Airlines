package com.lti.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.Passenger;

@Repository
public class PassengerRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	public void addPassengerDetails(Passenger passenger) {
		
		entityManager.merge(passenger);
		
	}

}
