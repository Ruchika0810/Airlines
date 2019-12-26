package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repository.RegisterationRepository;
import com.lti.repository.RegisterationRepositoryImpl;
import com.lti.model.Registeration;

@Service
public class RegisterationService {

	@Autowired
	private RegisterationRepository registerationDao; 

	public void addUsers(Registeration registeration) {
		if(!existByMailId(registeration.getEmail()))
			registerationDao.addUserDetails(registeration);
	}
	
	public boolean existByMailId(String email) {
		boolean f = false;
		if(registerationDao.existByMailId(email) > 0)
			f=true;
		return f;
		
	}
}
