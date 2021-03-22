package edu.westga.cs6312.recursion.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.westga.cs6312.recursion.model.TemperatureManager;

/**
 * Provides a view to display application data to the console. Interacts with
 * the user, requesting textual input, and loads data from text files.
 *
 * @author Spencer Dent
 * @version 2021-03-18
 */
public class TemperatureTUI {
    private Scanner keyboard;
    private TemperatureManager primaryManager;

    /**
     * Creates a new TemperatureTUI (textual user interface) with the provided
     * TemperatureManager serving as its primary TemperatureManager. This method
     * also sets up the keyboard to allow for user input.
     * 
     * @param newManager - the TemperatureManager to use
     */
    public TemperatureTUI(TemperatureManager newManager) {
        this.keyboard = new Scanner(System.in);
        this.primaryManager = newManager;
    }

    /**
     * Acts as the primary workflow of the textual application. It loops the
     * application until the user quits, handles the selection menu, calls the
     * appropriate helper methods, and closes the keyboard on termination to prevent
     * leaks.
     */
    public void run() {
        System.out.println("Welcome to the Temperature Manager Application.");
        System.out.println();

        int userSelection;
        do {
            this.printMenuOptions();
            userSelection = this.getUserInt("Please enter your choice");
            System.out.println();

            switch (userSelection) {
                case 1:
                    this.addTemperaturesFromFile();
                    break;
                case 2:
                    this.displayOriginalList();
                    break;
                case 3:
                    this.displayLoopReversedList();
                    break;
                case 4:
                    this.displayRecursionReversedList();
                    break;
                case 5:
                    System.out.println("Thank you for using the Temperature Manager Application");
                    System.out.println("Goodbye");
                    break;
                default:
                    System.out.println("Not a valid selection. Please try again.");
                    break;
            }
            System.out.println();
        } while (userSelection != 5);

        this.keyboard.close();
    }

    /**
     * Prints the available menu options to the console.
     */
    private void printMenuOptions() {
        System.out.println("1 - Add temperatures from file");
        System.out.println("2 - Display the original temperatures on the console");
        System.out.println("3 - Display the loop-reversed list on the console");
        System.out.println("4 - Display the recursion-reversed list on the console");
        System.out.println("5 - Quit");
    }

    /**
     * Prompts the user for an input with the given message and returns the user's
     * input.
     */
    private String getUserLine(String message) {
        System.out.print(message + ": ");
        return this.keyboard.nextLine();
    }

    /**
     * Prompts the user for an integer value via the provided message, obtains the
     * user's input, coverts the user input to an integer, and returns the converted
     * input. Continues to prompt the user if the input is invalid.
     * 
     * @param message - the prompt to display to the user
     * @return the user's input converted into an integer
     */
    private int getUserInt(String message) {
        int userInt = -1;
        boolean isValid = false;

        do {
            String inputtedLine = this.getUserLine(message);
            try {
                userInt = Integer.parseInt(inputtedLine);
                isValid = true;
            } catch (NumberFormatException numberFormatException) {
                System.out.println();
                System.out.println("That wasn't a valid integer. Please try again.");
            }
        } while (!isValid);

        return userInt;
    }

    /**
     * Opens a text file (located at the path provided by the user), reads
     * temperature values from each of its lines, and inserts the temperature values
     * into the primary TemperatureManager.
     */
    private void addTemperaturesFromFile() {
        String userProvidedPath = this.getUserLine("Please enter file containing the temperatures");

        File userSelectedFile = new File(userProvidedPath);
        try (Scanner selectedFileScanner = new Scanner(userSelectedFile)) {
            while (selectedFileScanner.hasNextLine()) {
                String currentLine = selectedFileScanner.nextLine();

                try {
                    int currentNumber = Integer.parseInt(currentLine);
                    System.out.println("Read temperature: " + currentNumber);
                    this.primaryManager.addTemperature(currentNumber);
                } catch (NumberFormatException numberFormatException) {
                    System.out.println("Error: " + currentLine + " cannot be converted to a number");
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("That file does not exist. Returning to main menu.");
            return;
        }
    }

    /**
     * Calls the primary TemperatureManager's toString method and prints the result
     * to the console.
     */
    private void displayOriginalList() {
        System.out.println("The original temperatures are:");
        System.out.println(this.primaryManager.toString());
    }

    /**
     * Calls the primary TemperatureManager's reverseLoop method and prints the
     * result to the console.
     */
    private void displayLoopReversedList() {
        System.out.println("The loop-reversed temperatures are:");
        System.out.println(this.primaryManager.reverseLoop());
    }

    /**
     * Calls the primary TemperatureManager's reverseRecursion method and prints the
     * result to the console.
     */
    private void displayRecursionReversedList() {
        System.out.println("The recursive-reversed temperatures are:");
        System.out.println(this.primaryManager.reverseRecursion());
    }
}
