package com.tutorial.jpa.jpademo.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tutorial.jpa.jpademo.entity.Course;

@Repository
@Transactional
public class CourseRepository {
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
	
	
}
