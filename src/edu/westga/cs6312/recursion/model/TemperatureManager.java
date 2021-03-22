package edu.westga.cs6312.recursion.model;

import java.util.ArrayList;

/**
 * Provides a model to store and return a list of temperatures in multiple
 * orientations (forwards and backwards).
 *
 * @author Spencer Dent
 * @version 2021-03-16
 */
public class TemperatureManager {
	private ArrayList<Integer> listOfTemperatures;

	/**
	 * Constructs a new TemperatureManager, initializing its list of temperatures.
	 */
	public TemperatureManager() {
		this.listOfTemperatures = new ArrayList<Integer>();
	}

	/**
	 * Returns the list of temperatures as a space-delimited, single-line String in
	 * insertion order.
	 * 
	 * @return the String representation of the TemperatureManager object
	 */
	@Override
	public String toString() {
		String output = "";

		for (int currentTemperature : this.listOfTemperatures) {
			output += currentTemperature + " ";
		}

		return output.trim();
	}

	/**
	 * Appends a new temperature to the list.
	 * 
	 * @param newTemperature -- the new temperature to add
	 */
	public void addTemperature(int newTemperature) {
		this.listOfTemperatures.add(newTemperature);
	}
}
