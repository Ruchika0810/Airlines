package com.lti.repository;


import com.lti.model.Registeration;


public interface LoginRepository {
	public Registeration fetch(String email,String password);
}