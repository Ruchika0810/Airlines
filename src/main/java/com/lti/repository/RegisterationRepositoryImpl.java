package com.lti.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lti.model.Registeration;


@Repository
@Component("reg1")
public class RegisterationRepositoryImpl implements RegisterationRepository{

	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addUserDetails(Registeration registeration) {
		entityManager.persist(registeration);

	}
	
	public long existByMailId(String email) {
		
		Query q = entityManager.createQuery("select count(l) from Registeration l where l.email = :em");
		q.setParameter("em", email);
		return (Long)q.getSingleResult();
	}

}
