package edu.westga.cs6312.recursion.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.recursion.model.TemperatureManager;

/**
 * Provides unit tests to verify the expected behavior of the addTemperature
 * method in the TemperatureManager class.
 * 
 * @author Spencer Dent
 * @version 2021-03-16
 */
public class TemperatureManagerWhenAddTemperature {

	/**
	 * Tests the case where the TemperatureManager does not contain any temperatures
	 * yet. It should add the temperature to the list, making the list of size 1.
	 */
	@Test
	public void testAddTemperatureShouldAddNewTemperatureToList() {
		TemperatureManager managerOfOne = new TemperatureManager();
		managerOfOne.addTemperature(0);
		String actualOutput = managerOfOne.toString();

		assertEquals("0", actualOutput);
	}

	/**
	 * Tests the inserting on empty case again to prevent the developer from
	 * hard-coding the value in order to pass the previous test.
	 */
	@Test
	public void testAddTemperatureAgainToPreventHardCoding() {
		TemperatureManager anotherManager = new TemperatureManager();
		anotherManager.addTemperature(212);
		String actualOutput = anotherManager.toString();

		assertEquals("212", actualOutput);
	}

	/**
	 * Tests the case where the TemperatureManager already has a temperature in the
	 * list. It should append the new temperature to the end of the list.
	 */
	@Test
	public void testAddTemperatureWhenListAlreadyContainsATemperatureShouldAppendNewTemperature() {
		TemperatureManager twinManager = new TemperatureManager();
		twinManager.addTemperature(22);
		twinManager.addTemperature(77);
		String actualOutput = twinManager.toString();

		assertEquals("22 77", actualOutput);
	}
}
