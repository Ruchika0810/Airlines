package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.repository.LoginRepository;
import com.lti.repository.LoginRepositoryImpl;

import com.lti.model.Registeration;

@Service
public class LoginService {

	@Autowired
	private LoginRepository loginDao;
	
	public Registeration login(String email, String password) 
	{
		
		Registeration log = loginDao.fetch(email, password);
			return log;	
		
		
	}
}
