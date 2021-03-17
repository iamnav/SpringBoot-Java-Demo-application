package com.demo.client;

import com.demo.model.RestaurantResponse;
import com.demo.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * The Restaurant API Client class
 * 
 * @author iamnav
 *
 */
@Component
public class RestaurantsClient {
	@Autowired
	RestTemplate restTemplate;

	/**
	 * Method to get list of restaurants from the API
	 * 
	 * @return
	 */
	public RestaurantResponse getRestaurants() {
		ResponseEntity<String> response = restTemplate.getForEntity(Constants.RESTAURANTS_URL, String.class, 1);
		if (response.getStatusCode() == HttpStatus.OK) {
			return parseResponse(response.getBody());
		} else {
			return null;
		}
	}

	private RestaurantResponse parseResponse(String json) {
		final ObjectMapper objectMapper = new ObjectMapper();
		RestaurantResponse resp = new RestaurantResponse();

		try {
			resp = objectMapper.readValue(json, RestaurantResponse.class);
		} catch (IOException e) {
		}

		return resp;
	}
}
