package org.example.VideoGame;

import org.example.Scanner.MyScanner;


import java.util.InputMismatchException;

public class VideoGameInputs extends MyScanner{
    //static UserScanner scanner = new UserScanner();

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
                System.out.print("\nPlease Enter Video Game Price: ");
                doubleInput = getDouble();
            }catch (InputMismatchException e){
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return doubleInput;
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


