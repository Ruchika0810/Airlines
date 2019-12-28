package com.lti.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.FlightSchedule;
import com.lti.model.FlightsDetails;
import com.lti.repository.FlightDetailsRepository;

@Service
public class FlightDetailsService {

	@Autowired
	FlightDetailsRepository flightDetailsRepository;

	public List<FlightSchedule> fetchFlight(String source, String destination, LocalDate travelDate, int passengers) {
		List<FlightSchedule> flights = flightDetailsRepository.fetchFlight(source, destination, travelDate);
		List<FlightSchedule> flightsavailable = new ArrayList<FlightSchedule>();
		for (int i = 0; i < flights.size(); i++) {
			int pass=flights.get(i).getFlightsDetails().getSeatAvailablity() ;
			if(pass>=passengers ){
				flightsavailable.add(flights.get(i));
			}
		}      
		return flightsavailable;
	}
	
	public FlightsDetails findFlightDetails(int id) {
		return flightDetailsRepository.findFlightDetails(id);		
	}
	
	public void saveFlightDetals(FlightsDetails flightsDetails) {
		flightDetailsRepository.saveFlightDetals(flightsDetails);
	}
}
