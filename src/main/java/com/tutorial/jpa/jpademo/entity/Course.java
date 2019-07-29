package com.tutorial.jpa.jpademo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Table(name="CourseDetails") //테이블 이름을 이렇게 매핑 시킬 수 있다. 
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	//@Column(name="fullname") //테이블 컬럼은 이렇게 매핑시킨다.
	@Column(nullable=false)
	private String name;
	
	protected Course() {}
	
	public Course(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
