package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.FlightsDetails;
import com.lti.repository.FlightDetailsRepository;

@Service
public class FlightDetailsService {
	
	@Autowired
	FlightDetailsRepository flightDetailsRepository;
	
	public FlightsDetails fetchFlight(String source, String destination, LocalDate date) {
		return flightDetailsRepository.fetchFlight(source, destination, date);
	}
}
