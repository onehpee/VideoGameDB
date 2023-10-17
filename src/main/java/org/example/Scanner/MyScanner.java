package org.example.Scanner;

import org.example.Exception.BlankInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MyScanner {

    private static Scanner scanner = new Scanner(System.in);


    // This methods gets integer values from user.
    protected static int getInt() {
        String newIntInput = getString();
        int newIntValue;
        try{
           newIntValue = Integer.parseInt(newIntInput);
        } catch (NumberFormatException e) {
            throw new InputMismatchException("Incorrect Input - Please Enter Numerical Values Only");
        }
        return newIntValue;
    }

    // This method gets string values from user.
    protected static String getString() {
        String stringValue = scanner.nextLine();
        if (stringValue.isBlank()) throw new BlankInputException();
        return stringValue;
    }

    // This method closes the scanner to prevent leakage.
    protected static void closeScanner() {
        scanner.close();
    }
}
