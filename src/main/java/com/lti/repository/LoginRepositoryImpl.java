package com.lti.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.model.Registeration;


@Repository
public class LoginRepositoryImpl implements LoginRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	public Registeration fetch(String email, String password) {
		
		Query q = entityManager.createQuery("select l from Registeration l where l.email =:em and l.password =:pwd");
		q.setParameter("em", email);
		q.setParameter("pwd", password);
		return (Registeration)q.getSingleResult();
	}

}
