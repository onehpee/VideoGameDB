package org.example.Exception;

/**
 * Custom exception class that gets thrown
 * when the user does not input anything to the scanner
 */
public class BlankInputException extends RuntimeException{

    //Constructor that calls the parent RuntimeException object with custom message
    public BlankInputException(){
        super("Incorrect Input - Please Enter Value");
    }
}
