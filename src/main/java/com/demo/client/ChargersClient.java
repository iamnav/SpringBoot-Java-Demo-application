package com.demo.client;

import com.demo.model.ChargersResponse;
import com.demo.util.Constants;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * The Chargers API client class
 * 
 * @author iamnav
 *
 */
@Component
public class ChargersClient {
	RestTemplate restTemplate = new RestTemplate();

	/**
	 * Method to get all chargers from the API
	 * 
	 * @return
	 */
	public ChargersResponse getChargers() {
		ResponseEntity<String> response = restTemplate.getForEntity(Constants.CHARGERS_URL, String.class, 1);
		if (response.getStatusCode() == HttpStatus.OK) {
			return parseResponse(response.getBody());
		} else {
			return null;
		}
	}

	private ChargersResponse parseResponse(String json) {
		final ObjectMapper objectMapper = new ObjectMapper();
		ChargersResponse chargers = new ChargersResponse();

		try {
			chargers = objectMapper.readValue(json, ChargersResponse.class);
		} catch (IOException e) {
		}

		return chargers;
	}
}
