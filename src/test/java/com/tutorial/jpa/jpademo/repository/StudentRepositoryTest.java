package com.tutorial.jpa.jpademo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.junit4.SpringRunner;

import com.tutorial.jpa.jpademo.JpademoApplication;
import com.tutorial.jpa.jpademo.entity.Passport;
import com.tutorial.jpa.jpademo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpademoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(StudentRepositoryTest.class);

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	PassportRepository passportRepository;

	@Autowired
	EntityManager em;
	
	//@Test
	public void 학생과_여권을_1개_저장한다() {
		Passport passport = new Passport("z123123"); // passport가 데이터베이스에 없다. 따라서 foreign key에러남. 먼저 저장해줘야한다.
		passportRepository.save(passport);
		Student student = new Student("steve");
		student.setPassport(passport); 
		studentRepository.save(student);
	}
	
	@Test
	@Transactional
	public void 학생의_정보를_조회해온다_fetch_Type() {
		Student student = em.find(Student.class, 20001L);
		logger.info("student -> {}", student); //디폴트가 eagerFetch라 student만 조회해도 passport를 left join 시켜서 조회한다.
		logger.info("passport -> {}", student.getPassport());
	}

}
