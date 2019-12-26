package com.lti.repository;

import com.lti.model.Registeration;

public interface RegisterationRepository {
	public long existByMailId(String email);
	public void addUserDetails(Registeration registeration);
}
