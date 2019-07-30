package com.tutorial.jpa.jpademo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.jpa.jpademo.entity.Passport;

@Repository
@Transactional
public class PassportRepository {
	
	private Logger logger = LoggerFactory.getLogger(PassportRepository.class);
	
	@Autowired
	EntityManager em;
	
	public Passport findById(Long id) {
		return em.find(Passport.class, id);
	}
	
	public void deleteById(Long id) {
		Passport passport = findById(id);
		em.remove(passport);
	}
	
	public Passport save(Passport passport) {
		if (passport.getId() == null) {
			em.persist(passport);
		}else {
			em.merge(passport);
		}
		return passport;
	}
}
