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

	/**
	 * Creates a space-delimited, single-line String out of the list of temperatures
	 * in reverse order of insertion.
	 * 
	 * The internal implementation uses a loop.
	 * 
	 * @return the reversed list String
	 */
	public String reverseLoop() {
		String output = "";

		for (int currentIndex = this.listOfTemperatures.size() - 1; currentIndex >= 0; currentIndex--) {
			output += this.listOfTemperatures.get(currentIndex) + " ";
		}

		return output.trim();
	}

	/**
	 * Creates a space-delimited, single-line String out of the list of temperatures
	 * in reverse order of insertion.
	 * 
	 * The internal implementation uses recursion. This method calls a private
	 * helper method that actually performs the recursion. This method provides the
	 * initial values for the recursive method.
	 * 
	 * @return the reversed list String
	 */
	public String reverseRecursion() {
		return this.reverseHelper(this.listOfTemperatures.size() - 1).trim();
	}

	/**
	 * Serves as the recursive private helper method for reverseRecursion. This
	 * method does the actual recursion necessary to perform the reverse task.
	 * 
	 * @param currentIndex -- first call: the initial index (last temperature),
	 *                     subsequent calls: next index
	 * @return the reversed list String
	 */
	private String reverseHelper(int currentIndex) {
		if (currentIndex < 0) {
			return "";
		}
		return this.listOfTemperatures.get(currentIndex) + " " + this.reverseHelper(currentIndex - 1);
	}
}
