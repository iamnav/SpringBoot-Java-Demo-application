package com.demo.model;

import java.util.ArrayList;
import java.util.List;

/***
 * The EVResponse model class.
 * 
 * @author iamnav
 *
 */
public class EVResponse {
	private List<CodeRestaurantResponse> response;

	// Constructor
	public EVResponse() {
		response = new ArrayList<>();
	}

	public void addResponse(CodeRestaurantResponse resp) {
		response.add(resp);
	}

	// Getter and Setter
	public List<CodeRestaurantResponse> getResponse() {
		return response;
	}

	public void setResponse(List<CodeRestaurantResponse> response) {
		this.response = response;
	}

}
