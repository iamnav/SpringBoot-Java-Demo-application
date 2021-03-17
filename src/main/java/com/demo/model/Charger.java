package com.demo.model;

import java.util.List;

/**
 * The Charger model class
 * 
 * @author iamnav
 *
 */
public class Charger {
	private List<Integer> array;

	public List<Integer> getArray() {
		return array;
	}

	public void setArray(List<Integer> array) {
		this.array = array;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Charger [array=");
		builder.append(array);
		builder.append("]");
		return builder.toString();
	}
}