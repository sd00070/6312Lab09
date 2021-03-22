package edu.westga.cs6312.recursion.controller;

import edu.westga.cs6312.recursion.model.TemperatureManager;
import edu.westga.cs6312.recursion.view.TemperatureTUI;

/**
 * Provides an entry point for the TemperatureManager Application. Allows the
 * program to run from the terminal.
 *
 * @author Spencer Dent
 * @version 2021-03-18
 */
public class TemperatureDriver {

	/**
	 * This method is the entry point of the application
	 *
	 * @param args Command-line arguments, not used
	 */
	public static void main(String[] args) {
		TemperatureManager primaryManager = new TemperatureManager();
		TemperatureTUI textualUserInterface = new TemperatureTUI(primaryManager);
		textualUserInterface.run();
	}
}
