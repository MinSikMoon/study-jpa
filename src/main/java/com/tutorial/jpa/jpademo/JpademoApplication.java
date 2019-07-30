package com.tutorial.jpa.jpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tutorial.jpa.jpademo.repository.CourseRepository;
import com.tutorial.jpa.jpademo.repository.StudentRepository;

@SpringBootApplication
public class JpademoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository courseRepository;
	private StudentRepository studentRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		courseRepository.playWithEntityManager();
		//studentRepository.playWithEntityManager();
	}
}
