package com.lti.repository;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.FlightsDetails;

@Repository
public class FlightDetailsRepository {
		
		@PersistenceContext
		EntityManager entityManager;
		
		public FlightsDetails fetchFlight(String source, String destination, LocalDate date) {
			
			Query q= entityManager.createQuery("select f from FlightsDetails f  where f.source=:so and f.destination=:des and f.flightId in(select f.flightId from FlightSchedule s where s.scheduleDate=:dat)");
			q.setParameter("so", source);
			q.setParameter("des", destination);
			q.setParameter("dat", date);
			FlightsDetails flightsDetails = (FlightsDetails) q.getSingleResult();
			return flightsDetails;
		}
}
