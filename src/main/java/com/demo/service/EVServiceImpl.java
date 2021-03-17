package com.demo.service;

import com.demo.client.ChargersClient;
import com.demo.client.RestaurantsClient;
import com.demo.model.Charger;
import com.demo.model.ChargersResponse;
import com.demo.model.CodeRestaurantResponse;
import com.demo.model.EVResponse;
import com.demo.model.Restaurant;
import com.demo.model.RestaurantResponse;
import com.demo.util.Constants;
import com.demo.util.Top10RestaurantsPicker;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/***
 * The EVServiceImpl class.
 * 
 * @author iamnav
 *
 */
@Service
public class EVServiceImpl implements EVService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EVServiceImpl.class);

	@Autowired
	ChargersClient chargersClient;

	@Autowired
	RestaurantsClient restaurantsClient;

	@Autowired
	Top10RestaurantsPicker picker;

	@Override
	public EVResponse getResponse(Integer currFuel) {
		LOGGER.debug("Start of the getResponse method");

		LOGGER.debug("Retrieving chargers");
		ChargersResponse chargers = chargersClient.getChargers();

		LOGGER.debug("Retrieving restaurants");
		RestaurantResponse restaurants = restaurantsClient.getRestaurants();

		EVResponse response = new EVResponse();
		List<Restaurant> topRestaurants = getTopRestaurants(restaurants, 10);

		for (Charger charger : chargers.getChargers()) {
			CodeRestaurantResponse currResp = new CodeRestaurantResponse();

			// Advanced Condition: Check if chargers are even needed
			if (currFuel >= charger.getArray().size()) {
				LOGGER.debug("We can reach the destination without charging");

				currResp.setRouteCode(Constants.CODE_IGNORE);
				currResp.setRestaurants(topRestaurants);
			}

			// Otherwise, continue with the normal check
			else {
				LOGGER.debug("We can't reach the destination without charging, running algo.");

				if (isRoutePossible(charger.getArray(), currFuel)) {
					currResp.setRouteCode(Constants.CODE_SUCCESS);
				} else {
					currResp.setRouteCode(Constants.CODE_FAILURE);
				}
			}

			response.addResponse(currResp);
		}

		return response;
	}

	/**
	 * Method to get top restaurants by rating
	 * 
	 * @param restaurants
	 * @param count       - How many top restaurants are needed
	 * @return List<Restaurant>
	 */
	private List<Restaurant> getTopRestaurants(RestaurantResponse restaurants, Integer count) {
		return picker.getTopRestaurants(restaurants.getRestaurants(), count);
	}

	/**
	 * Method to check whether an EV starting from -1 position can cross the total
	 * distance or not
	 * 
	 * @param array
	 * @param currFuel
	 * @return Boolean (True = if EV can cross, otherwise False)
	 */
	private boolean isRoutePossible(List<Integer> array, Integer currFuel) {
		for (int i = 0; i < array.size(); ++i) {
			if (currFuel <= 0)
				return false;

			if (currFuel >= array.size())
				return true;

			currFuel += (array.get(i) - 1);
		}

		return true;
	}
}
