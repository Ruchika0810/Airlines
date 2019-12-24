package com.lti.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import com.lti.model.Registeration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.lti.service.RegisterationService;

@Controller
public class RegisterationController {


	@Autowired
	private RegisterationService registerationService; 
	
	@ControllerAdvice
	public class LocalDateControllerAdvice {

		@InitBinder
		public void initBinder(WebDataBinder binder) {
			binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport() {
				@Override
				public void setAsText(String text) throws IllegalArgumentException {
					setValue(LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd")));
				}
			});
		}
	}

	@RequestMapping(path = "/addDetails.lti", method = RequestMethod.POST)
	public String addNewDetails(Registeration registeration) {//,@RequestParam("dateOfBirth") String dob) {
		
		//LocalDate dt=LocalDate.parse(dob);
		//registeration.setDateOfBirth(dt);
		
		
		registerationService.addUsers(registeration);
		
		return "Login.jsp";
	}
	
}
