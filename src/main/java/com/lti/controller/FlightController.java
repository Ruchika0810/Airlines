package com.lti.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lti.model.FlightSchedule;

import com.lti.model.Registeration;
import com.lti.service.FlightDetailsService;
import com.lti.service.LoginService;

@Controller
@SessionAttributes({"loggedInPassenger","passengers"})
public class FlightController {

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
		public String fetchFlight(ModelMap model,@RequestParam("source")String source, @RequestParam("destination")String destination, 
				@RequestParam("from")LocalDate date,@RequestParam("passengers") int passengers){
			List<FlightSchedule> details ;
			try{
				details=flightDetailsService.fetchFlight(source, destination, date,passengers);
				model.put("flightList", details);
				model.put("source", details.get(0).getFlightsDetails().getSource());
				model.put("destination", details.get(0).getFlightsDetails().getDestination());
				model.put("passengers", passengers);
				return "FlightSelect.jsp";
			}
			catch(Exception e) {
				model.put("fail", "No Flights Found");
				return "Failure.jsp";
			}
			
		}
		
		@Autowired
		private LoginService loginService;
		
		@RequestMapping(path="/login.lti",method=RequestMethod.POST)
		public String loginFlight(@RequestParam("email") String email,@RequestParam("password") String password,ModelMap model) {
		
			try {
				Registeration login = loginService.login(email, password);
				model.put("loggedInPassenger",login);
				return "success.jsp";
			}
			catch(Exception e) {
				model.put("fail", "Login Again");
				return "Login.jsp";
			}
		}
}		
