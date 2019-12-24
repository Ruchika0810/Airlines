package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.model.Passenger;
import com.lti.service.PassengerService;

@Controller
public class PassengerController {

	@Autowired
	private PassengerService passengerService;
	
	@RequestMapping(path="/addPassenger.lti", method = RequestMethod.POST)
	public void addPassengerDetails(Passenger passenger) {
		
		passengerService.passengerDetails(passenger);
		
	}
	
}
