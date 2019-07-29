package com.tutorial.jpa.jpademo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
//@Table(name="CourseDetails") //테이블 이름을 이렇게 매핑 시킬 수 있다. 

//@NamedQuery(name = "query_select_all_courses", query = "select c from Course c") //쿼리를 알리안스로 쓸수 있다.
//@NamedQuery(name = "query_select_math_like_courses", query = "Select c from Course c where name like '%math%'") //두개를 못쓴다
@Entity
@NamedQueries(value = { 
		@NamedQuery(name = "query_select_all_courses", query = "select c from Course c"),
		@NamedQuery(name = "query_select_math_like_courses", query = "Select c from Course c where name like '%math%'")
		})
public class Course {
	
	@Id
	@GeneratedValue
	private Long id;
	
	//@Column(name="fullname") //테이블 컬럼은 이렇게 매핑시킨다.
	@Column(nullable=false)
	private String name;
	
	@UpdateTimestamp //update 될때 마다 자동으로 타임스탬프가 갱신되는 하이버네이트 어노테이션
	private LocalDateTime lastUpdatedDate;
	
	@CreationTimestamp
	private LocalDateTime createdDate;
	
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
