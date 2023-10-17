package org.example.VideoGame;

import org.example.User.UserScanner;

import java.util.InputMismatchException;

public class VideoGameInputs {
    static UserScanner scanner = new UserScanner();

    public static int getIDInput(){
        int intInput = -1;
        while (intInput < 0){
            try {
                System.out.println("\nPlease Enter Video Game ID#: ");
                intInput = scanner.getInt();
            }catch (InputMismatchException e){
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return intInput;
    }

    public static String getStringInput(VideoGameInputFields fieldString){
        String userString = " ";
        while (userString.isBlank()){
            try {
                System.out.println("Please Enter " + fieldString.field + ": " );
                userString = scanner.getString();
            }catch (InputMismatchException e){
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return userString;
    }

    public static void closeScanner(){
        scanner.closeScanner();
    }
}


