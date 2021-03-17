package com.demo.model;

import java.util.List;

/**
 * The Code-Restaurant response model class
 * 
 * @author iamnav
 *
 */
public class CodeRestaurantResponse {
	private Integer routeCode;
	private List<Restaurant> restaurants;

	// Getters and Setters
	public Integer getRouteCode() {
		return routeCode;
	}

	public void setRouteCode(Integer routeCode) {
		this.routeCode = routeCode;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
}
