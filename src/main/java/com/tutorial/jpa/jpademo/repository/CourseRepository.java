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
		Course course1 = new Course("new course for testing");
		em.persist(course1);
		Course course2 = new Course("new course2 for testing");
		em.persist(course2);
		em.flush(); //사실 요게 다 들어가있다. db에 반영시켜라는거
		
		//em.clear(); //course1, course2 모두 detach시키는 효과
		//em.detach(course2);//detach된 entity는 entyty manager가 더이상 추적하지 않는다. //coure1만 업데이트된다.
		course1.setName("what would happen if i change this course1 name");
		course2.setName("what would happen if i change this course2 name");
		em.refresh(course1);
		
		course2.setName("i changed course2 name again"); //여기서 update가 한번 되므로 updatedtime이 달라질것이다.
		em.flush(); //사실 요게 다 들어가있다. db에 반영시켜라는거
	}
}
