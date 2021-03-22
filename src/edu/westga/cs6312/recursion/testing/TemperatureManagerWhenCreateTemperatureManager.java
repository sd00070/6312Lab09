package edu.westga.cs6312.recursion.testing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.westga.cs6312.recursion.model.TemperatureManager;

/**
 * Provides a unit test to verify the expected behavior of TemperatureManager's
 * constructor and toString method.
 * 
 * As neither method change the internal state of the object and other cases are
 * reliant on other methods, the other cases will be tested in the other JUnit
 * files.
 * 
 * @author Spencer Dent
 * @version 2021-03-16
 */
public class TemperatureManagerWhenCreateTemperatureManager {

	/**
	 * Tests the constructor that it produces a new TemperatureManager object and
	 * tests that the new object has a toString method.
	 * 
	 * As the state cannot change without the use of untested methods, this is the
	 * only case I can test in this file.
	 */
	@Test
	public void testTemperatureManagerConstructorFollowedByToStringShouldReturnBlank() {
		TemperatureManager emptyManager = new TemperatureManager();
		String actualOutput = emptyManager.toString();

		assertEquals("", actualOutput);
	}

}
