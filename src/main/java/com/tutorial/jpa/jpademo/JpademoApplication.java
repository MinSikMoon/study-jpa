package com.tutorial.jpa.jpademo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tutorial.jpa.jpademo.repository.CourseRepository;

@SpringBootApplication
public class JpademoApplication {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CourseRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(JpademoApplication.class, args);
	}
}