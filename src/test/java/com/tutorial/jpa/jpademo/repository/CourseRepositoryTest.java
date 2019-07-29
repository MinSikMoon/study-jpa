package com.tutorial.jpa.jpademo.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.jpa.jpademo.JpademoApplication;
import com.tutorial.jpa.jpademo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=JpademoApplication.class)
public class CourseRepositoryTest {
	
	private Logger logger = LoggerFactory.getLogger(CourseRepositoryTest.class);
	
	@Autowired
	CourseRepository repository;
	
	@Test
	@Order(1)
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
	
	@Test
	@Order(2)
	public void id로_해당하는_course를_1개찾는다() {
		Course course = repository.findById(10001L);
		assertEquals("mathematics", course.getName());
	}
	
	@Test
	@Order(3)
	@DirtiesContext //이전의 상태로 리셋해놓는다.
	public void id에_해당하는_course를_삭제한다() {
		repository.deleteById(10001L);
		assertNull(repository.findById(10001L));
	}
	
	@Test
	@Order(4)
	@DirtiesContext //이전의 상태로 리셋해놓는다.
	public void id에_해당하는_course를_update한다() {
		Course course = repository.findById(10001L);
		course.setName("forTest");
		repository.save(course);
		course = repository.findById(10001L);
		assertEquals("forTest", course.getName());
	}
	
	@Test(expected=DataIntegrityViolationException.class)
	@Order(5)
	@DirtiesContext //이전의 상태로 리셋해놓는다.
	public void 컬럼이_not_nullable이라면_익셉션일날것() {
		Course course = repository.findById(10001L);
		course.setName(null);
		repository.save(course);
		course = repository.findById(10001L);
		assertEquals("forTest", course.getName());
	}
	
	

}
