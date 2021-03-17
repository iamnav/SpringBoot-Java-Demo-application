package com.demo.model;

import java.util.List;

/**
 * The Chargers API response model class
 * 
 * @author iamnav
 *
 */
public class ChargersResponse {
	private List<Charger> chargers;

	public List<Charger> getChargers() {
		return chargers;
	}

	public void setChargers(List<Charger> chargers) {
		this.chargers = chargers;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ChargersResponse [chargers=");
		builder.append(chargers);
		builder.append("]");
		return builder.toString();
	}
}
