package com.tutorial.jpa.jpademo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.jpa.jpademo.entity.Course;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger logger = LoggerFactory.getLogger(CourseRepository.class);
	
	@Autowired
	EntityManager em;
	
	public Course findById(Long id) {
		return em.find(Course.class, id);
	}
	
	public void deleteById(Long id) {
		Course course = findById(id);
		em.remove(course);
	}
	
	public Course save(Course course) {
		if (course.getId() == null) {
			em.persist(course);
		}else {
			em.merge(course);
		}
		return course;
	}
	
	//entityManager 학습
	//@transactional이 붙어서 이 메소드는 하나의 transaction으로 취급된다. 따라서 setName하면 update까지 된다.
	//트랜잭션안에서 변화가 생기면 entitymanager가 다 추적해서 관리한다. 그래서 update(merge)까지 시켜버림.
	public void playWithEntityManager() {
		Course course = new Course("new course for testing");
		em.persist(course);
		course.setName("what would happen if i change this course name");
	}
}
