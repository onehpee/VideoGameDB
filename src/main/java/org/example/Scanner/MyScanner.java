package org.example.Scanner;

import org.example.Exception.BlankInputException;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    protected static double getDouble(){
        String newDoubleInput = getString();
        double newDoubleValue;
        try {
            newDoubleValue = Double.parseDouble(newDoubleInput);
        }catch (NumberFormatException e){
            throw  new InputMismatchException("Incorrect Input - Please Enter Numerical Values Only");
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(newDoubleValue));
    }

    protected static LocalDate getDate() {
        String newIntInput = getString();
        String dateFormat = "MM/dd/yyyy";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat);
        LocalDate date;
        try{
            date = LocalDate.parse(newIntInput, dateTimeFormatter);
        } catch(Exception e) {
            throw new InputMismatchException("Incorrect Input - Date In Following Format (" + dateFormat + ")");
        }
        return date;
    }

    // This method gets string values from user.
    protected static String getString() {
        String stringValue = scanner.nextLine();
        if (stringValue.isBlank()) throw new BlankInputException();
        return stringValue.trim();
    }

    // This method closes the scanner to prevent leakage.
    protected static void closeScanner() {
        scanner.close();
    }
}
