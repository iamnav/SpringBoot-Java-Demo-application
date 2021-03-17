package com.demo.model;

import java.util.List;

/**
 * The RestaurantResponse model class
 * 
 * @author iamnav
 *
 */
public class RestaurantResponse {
	private List<Restaurant> restaurants;

	// Getters and Setters
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	// toString
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RestaurantResponse [restaurants=");
		builder.append(restaurants);
		builder.append("]");
		return builder.toString();
	}

}
