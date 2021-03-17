package com.demo.service;

import com.demo.model.EVResponse;

/**
 * The EVService interface
 * 
 * @author iamnav
 *
 */
public interface EVService {
	/**
	 * The method to create response, the assumption is that each EV starts from -1
	 * position of the array
	 * 
	 * @param currFuel
	 * @return The EV Response object
	 */
	public EVResponse getResponse(Integer currFuel);
}
