package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repository.RegisterationDao;
import com.lti.model.Registeration;

@Service
public class RegisterationService {

	@Autowired
	private RegisterationDao registerationDao; 

	public void addUsers(Registeration registeration) {
		
		registerationDao.addUserDetails(registeration);
	}
}
