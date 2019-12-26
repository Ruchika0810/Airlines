package com.lti.repository;

import java.util.List;

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
	public void addPassengerDetails(List<Passenger> passenger) {
		
		for(Passenger p : passenger)
			entityManager.merge(p);
	}

}
