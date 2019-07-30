package com.tutorial.jpa.jpademo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Review {
	
	@Id
	@GeneratedValue
	private Long id;
	@Column(nullable=false)
	private String rating;
	@Column(nullable=false)
	private String description;
	
	protected Review() {}
	
	public Review(String number) {
		this.description = number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	
	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", rating=" + rating +", description=" + description + "]";
	}
	
	
	
}
