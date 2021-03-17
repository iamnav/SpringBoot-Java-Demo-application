package com.demo.controller;

import com.demo.model.EVResponse;
import com.demo.service.EVServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Controller class
 * 
 * @author iamnav
 *
 */
@RestController
@RequestMapping("/ev")
public class EVController {

	@Autowired
	private EVServiceImpl evService;

	// Get the response for ev, takes current fuel as query param
	@GetMapping("/route")
	public EVResponse getEVResponse(@RequestParam("curr-fuel") Integer currFuel) {
		return evService.getResponse(currFuel);
	}

	// Health Check URL
	@GetMapping("/health")
	public String healthCheck() {
		return "Service is up!";
	}
}
