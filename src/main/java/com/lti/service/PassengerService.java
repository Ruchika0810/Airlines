package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Passenger;
import com.lti.repository.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;
	
	public void passengerDetails(Passenger passenger) {
		
		passengerRepository.addPassengerDetails(passenger);
	}
}
