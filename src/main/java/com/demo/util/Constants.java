package com.demo.util;

/**
 * The constants class
 * 
 * @author iamnav
 *
 */
public class Constants {
	private Constants() {
	}

	// URL for chargers api
	public static final String CHARGERS_URL = "";

	// URL for restaurants api
	public static final String RESTAURANTS_URL = "";

	// Code for when EV can reach destination
	public static final Integer CODE_SUCCESS = 200;

	// Code for when EV cannot reach destination
	public static final Integer CODE_FAILURE = 400;

	// ADVANCE CASE: Code for when EV can reach destination without any charging
	public static final Integer CODE_IGNORE = 0;
}
