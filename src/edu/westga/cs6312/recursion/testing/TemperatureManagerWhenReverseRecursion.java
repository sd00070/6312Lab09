package edu.westga.cs6312.recursion.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.recursion.model.TemperatureManager;

/**
 * Provides unit tests to verify the expected behavior of TemperatureManager's
 * reverseRecursion method. The method should return a space-delimited,
 * single-line String containing each of the list's temperature values in
 * reverse order.
 * 
 * The method uses recursion as its implementation.
 * 
 * @author Spencer Dent
 * @version 2021-03-16
 */
public class TemperatureManagerWhenReverseRecursion {

	/**
	 * Tests the case where the internal list does not have any temperatures in it
	 * yet. It should return an empty String.
	 */
	@Test
	public void testReverseRecursionWhenListIsEmptyShouldReturnEmpty() {
		TemperatureManager emptyManager = new TemperatureManager();
		String actualOutput = emptyManager.reverseRecursion();

		assertEquals("", actualOutput);
	}

	/**
	 * Tests the case where the internal list has a single temperature. It should
	 * return a String which contains only the stored temperature.
	 */
	@Test
	public void testReverseRecursionWithOneItemShouldShowIt() {
		TemperatureManager managerOfOne = new TemperatureManager();
		managerOfOne.addTemperature(1);
		String actualOutput = managerOfOne.reverseRecursion();

		assertEquals("1", actualOutput);
	}

	/**
	 * Tests the case where the internal list has two temperatures. It return a
	 * String containing the temperatures in reverse order of insertion.
	 */
	@Test
	public void testReverseRecursionWhenHasTwoValuesShouldSwap() {
		TemperatureManager twinManager = new TemperatureManager();
		twinManager.addTemperature(22);
		twinManager.addTemperature(77);
		String actualOutput = twinManager.reverseRecursion();

		assertEquals("77 22", actualOutput);
	}

	/**
	 * Tests the case where the TemperatureManager contains multiple values. Should
	 * return a String that contains all of the temperatures in the list in reverse
	 * order of insertion.
	 */
	@Test
	public void testReverseRecursionWhenHasManyValuesShouldReturnReverseString() {
		TemperatureManager multiManager = new TemperatureManager();
		multiManager.addTemperature(0);
		multiManager.addTemperature(1);
		multiManager.addTemperature(2);
		multiManager.addTemperature(3);
		multiManager.addTemperature(4);
		multiManager.addTemperature(5);
		multiManager.addTemperature(6);
		multiManager.addTemperature(7);
		multiManager.addTemperature(8);
		multiManager.addTemperature(9);
		String actualOutput = multiManager.reverseRecursion();

		String expectedOutput = "9 8 7 6 5 4 3 2 1 0";

		assertEquals(expectedOutput, actualOutput);
	}
}
