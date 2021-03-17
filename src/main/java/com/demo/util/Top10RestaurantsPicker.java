package com.demo.util;

import com.demo.model.Restaurant;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import org.springframework.stereotype.Component;

@Component
public class Top10RestaurantsPicker {

	public List<Restaurant> getTopRestaurants(List<Restaurant> restaurants, Integer count) {
		List<Restaurant> top10 = new ArrayList<>();

		PriorityQueue<Restaurant> pq = new PriorityQueue<>(5, new RestaurantComparator());
		for (Restaurant restaurant : restaurants) {
			pq.add(restaurant);
		}

		// Get the most rated restaurants
		Restaurant curr = null;
		while (top10.size() != count) {
			if (pq.isEmpty()) {
				return top10;
			}

			curr = pq.poll();
			top10.add(curr);
		}

		return top10;
	}

}

/**
 * Comparator class for comparing ratings, the higher rating denotes better
 * restaurant
 * 
 * @author iamnav
 *
 */
class RestaurantComparator implements Comparator<Restaurant> {
	public int compare(Restaurant r1, Restaurant r2) {
		if (r1.getRating() < r2.getRating()) {
			return 1;
		} else if (r1.getRating() > r2.getRating()) {
			return -1;
		}
		return 0;
	}
}