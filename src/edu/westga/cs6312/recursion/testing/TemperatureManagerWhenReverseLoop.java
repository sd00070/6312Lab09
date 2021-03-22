package edu.westga.cs6312.recursion.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.recursion.model.TemperatureManager;

/**
 * Provides unit tests to verify the expected behavior of TemperatureManager's
 * reverseLoop method. The method should return a space-delimited, single-line
 * String containing each of the list's temperature values in reverse order.
 * 
 * The method must use a loop as its implementation.
 *
 * @author Spencer Dent
 * @version 2021-03-16
 */
public class TemperatureManagerWhenReverseLoop {

	/**
	 * Tests the case where the TemperatureManager has an empty list of
	 * temperatures. It should return an empty String.
	 */
	@Test
	public void testReverseLoopWhenListIsEmptyShouldReturnEmpty() {
		TemperatureManager emptyManager = new TemperatureManager();
		String actualOutput = emptyManager.reverseLoop();

		assertEquals("", actualOutput);
	}

	/**
	 * Tests the case where the TemperatureManager's temperature list contains a
	 * single value. It should return a String that contains only that value.
	 */
	@Test
	public void testReverseLoopWithOneItemShouldShowIt() {
		TemperatureManager managerOfOne = new TemperatureManager();
		managerOfOne.addTemperature(1);
		String actualOutput = managerOfOne.reverseLoop();

		assertEquals("1", actualOutput);
	}

	/**
	 * Tests the case where the list consists of two temperatures. It should return
	 * the list in reverse order of insertion.
	 */
	@Test
	public void testReverseLoopWhenHasTwoValuesShouldSwap() {
		TemperatureManager twinManager = new TemperatureManager();
		twinManager.addTemperature(22);
		twinManager.addTemperature(77);
		String actualOutput = twinManager.reverseLoop();

		assertEquals("77 22", actualOutput);
	}

	/**
	 * Tests the case where the TemperatureManager's list of temperatures contains
	 * multiple temperatures. It should return a String that lists all of the
	 * temperatures.
	 */
	@Test
	public void testReverseLoopWhenHasManyValuesShouldReturnReverseString() {
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
		String actualOutput = multiManager.reverseLoop();

		String expectedOutput = "9 8 7 6 5 4 3 2 1 0";

		assertEquals(expectedOutput, actualOutput);
	}
}
