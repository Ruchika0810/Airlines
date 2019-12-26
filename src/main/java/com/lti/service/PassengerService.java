package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.model.Passenger;
import com.lti.repository.PassengerRepository;

@Service
public class PassengerService {

	@Autowired
	private PassengerRepository passengerRepository;
	
	public void passengerDetails(List<Passenger> passenger) {
		
		passengerRepository.addPassengerDetails(passenger);
	}
}
