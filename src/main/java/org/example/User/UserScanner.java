package org.example.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserScanner {

    private Scanner scanner = new Scanner(System.in);


    // This methods gets integer values from user.
    public int getInt() {
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
    public String getString() {
        String stringValue = scanner.nextLine();
        if (stringValue.isBlank()) throw new InputMismatchException("Incorrect Input - Please Enter Value");
        return stringValue;
    }

    // This method closes the scanner to prevent leakage.
    public void closeScanner() {
        scanner.close();
    }
}
