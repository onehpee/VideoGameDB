package org.example.VideoGame;

import org.example.Scanner.MyScanner;


import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;

public class VideoGameInputs extends MyScanner{
    public static int getVideoGameIDInput(){
        int intInput = -1;
        while (intInput < 0){
            try {
                System.out.print("\nPlease Enter Video Game ID#: ");
                intInput = getInt();
            }catch (InputMismatchException e){
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return intInput;
    }

    public static double getPrice(){
        double doubleInput = -1;
        while (doubleInput < 0){
            try {
                System.out.print("\nPlease Enter Video Game Price: $");
                doubleInput = getDouble();
            }catch (Exception e){
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return doubleInput;
    }

    public static LocalDate getDateInput(){
        LocalDate date = null;
        while (date == null){
            try {
                System.out.print("\nPlease Enter Video Game Release Date (MM/dd/yyyy): ");
                date = getDate();
            }catch (Exception e){
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return date;
    }

    public static String getStringInput2(VideoGameInputFields fieldString){
        String userString = " ";
        while (userString.isBlank()){
            try {
                System.out.print("\nPlease Enter " + fieldString.field + ": ");
                userString = getString();
            }catch (InputMismatchException e){
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return userString;
    }

    //public static void closeScanner(){}
}


