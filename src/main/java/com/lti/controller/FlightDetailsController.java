package com.lti.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lti.model.FlightsDetails;
import com.lti.service.FlightDetailsService;

@Controller
public class FlightDetailsController {

		@Autowired
		FlightDetailsService flightDetailsService;
		
		@InitBinder
		public void initBinder(WebDataBinder binder) {
			binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
				@Override
				public void setAsText(String text) throws IllegalArgumentException {
					setValue(LocalDate.parse(text, DateTimeFormatter.ISO_DATE));
				}

				@Override
				public String getAsText() throws IllegalArgumentException {
					return DateTimeFormatter.ofPattern("yyyy-MM-dd").format((LocalDate) getValue());
				}

			});
		}
		
		@RequestMapping(path="/flight.lti", method = RequestMethod.POST)
		public String fetchFlight(@RequestParam("source")String source, @RequestParam("destination")String destination, @RequestParam("from")LocalDate date){
			FlightsDetails details =flightDetailsService.fetchFlight(source, destination, date);
			return "FlightSelect";
		}
}		
