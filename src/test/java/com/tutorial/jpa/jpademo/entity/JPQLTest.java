package com.tutorial.jpa.jpademo.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.jpa.jpademo.JpademoApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpademoApplication.class)
public class JPQLTest {
	
	private Logger logger = LoggerFactory.getLogger(JPQLTest.class);
	
	@Autowired
	EntityManager em;
	
	@Test
	public void jpql_select() {
		//Query query = em.createQuery("Select c from Course c");
		Query query = em.createNamedQuery("get_all_courses");
		List resultList = query.getResultList();
		logger.info("select c from Course c -> {}", resultList);
	}
	
	@Test
	public void jpql_select_typed() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c",Course.class);
		List resultList = query.getResultList();
		logger.info("select c from Course c -> {}", resultList);
	}
	
	@Test
	public void jpql_select_where() {
		TypedQuery<Course> query = em.createQuery("Select c from Course c where name like '%math%'",Course.class);
		List resultList = query.getResultList();
		logger.info("select c from Course c where name like '%math%' -> {}", resultList);
	}

}
