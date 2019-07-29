package com.tutorial.jpa.jpademo.entity;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

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
		Query query = em.createNamedQuery("query_select_all_courses");
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
	public void jpql_select_using_native_query() {
		Query query = em.createNativeQuery("Select * from Course",Course.class);
		List resultList = query.getResultList();
		logger.info("select * from Course -> {}", resultList);
	}
	
	@Test
	public void jpql_select_using_native_with_parameter() {
		Query query = em.createNativeQuery("Select * from Course where id = ?",Course.class);
		query.setParameter(1, 10001L);
		List resultList = query.getResultList();
		logger.info("Select * from Course where id = ? -> {}", resultList);
	}
	
	@Test
	public void jpql_select_using_native_with_named_parameter() {
		Query query = em.createNativeQuery("Select * from Course where id = :id",Course.class);
		query.setParameter("id", 10001L);
		List resultList = query.getResultList();
		logger.info("Select * from Course where id = :id -> {}", resultList);
	}
	
	@Test
	@Transactional
	public void jpql_select_using_native_query_update() {
		Query query = em.createNativeQuery("Update course set last_updated_date=sysdate()");
		int updatedRowCnt = query.executeUpdate();
		logger.info("updatedRowCnt -> {}", updatedRowCnt);
	}
	
	@Test
	public void jpql_select_where() {
		TypedQuery<Course> query = em.createNamedQuery("query_select_math_like_courses",Course.class);
		List resultList = query.getResultList();
		logger.info("select c from Course c where name like '%math%' -> {}", resultList);
	}

}
