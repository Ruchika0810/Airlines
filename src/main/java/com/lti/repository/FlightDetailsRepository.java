package com.lti.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.lti.model.FlightSchedule;
import com.lti.model.FlightsDetails;

@Repository
public class FlightDetailsRepository {
		
		@PersistenceContext
		EntityManager entityManager;
		
		//public void fetchFlight(String source, String destination, LocalDate date) {
		public List<FlightSchedule> fetchFlight(String source, String destination, LocalDate date) {
		/*	System.out.println("testing...........");
			Query q= entityManager.createQuery("select f from FlightsDetails f join fetch f.flightSchedules fs where f.source=:so and f.destination=:des");
			q.setParameter("so", source);
			q.setParameter("des", destination);
			List<FlightsDetails> fd=q.getResultList();
			
			for(FlightsDetails fdObj:fd) {
				List<FlightSchedule> fs=fdObj.getFlightSchedules();
				for(FlightSchedule fsObj:fs) {
					System.out.println(fdObj.getSource()+"  "+fdObj.getDestination()+" "+fsObj.getDepartureTime().toString());
				}
			}
			
			
			return fd;*/
			
			Query q = entityManager.createQuery("select fd from FlightsDetails fd where fd.source =: so and fd.destination =: des ");
			q.setParameter("so", source);
			q.setParameter("des", destination);
			List<FlightsDetails> flightDetails = q.getResultList();
			
			List<Integer> listfids = new ArrayList<Integer>();
			
			for(int i=0;i<flightDetails.size();i++) {
				listfids.add(flightDetails.get(i).getFlightId());
			}
			
			
			Query q2 = entityManager.createQuery("select sc from FlightSchedule sc where sc.scheduleDate =: dt and sc.flightsDetails.flightId IN (:fids )");
			q2.setParameter("dt", date);
			q2.setParameter("fids", listfids);
			List<FlightSchedule> flist = q2.getResultList();
			
			return flist;
		}
}
