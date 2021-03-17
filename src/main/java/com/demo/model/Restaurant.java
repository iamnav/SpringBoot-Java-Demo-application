package com.demo.model;

/**
 * The Restaurant model class
 * 
 * @author iamnav
 *
 */
public class Restaurant {
	private String name;
	private Integer rating;

	// Getters and Setters
	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurant [name=");
		builder.append(name);
		builder.append(", rating=");
		builder.append(rating);
		builder.append("]");
		return builder.toString();
	}
}