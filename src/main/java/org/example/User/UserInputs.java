package org.example.User;

import java.util.InputMismatchException;

public class UserInputs {

  static UserScanner scanner = new UserScanner();

  // This method gets ID input value from user.
  public static int getIDInput() {
        int intInput = -1;
        while (intInput < 0) {
            try {
                System.out.print("\nPlease Enter User ID#: ");
                intInput = scanner.getInt();
            } catch (InputMismatchException e) {
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }

        return intInput;
    }

    // This method determines which field that the user is trying to input
//    public static String getUserInput(UserInputFields fields){
//        System.out.println(fields.field);
//        String fieldStringDisplay = " ";
//        switch (fields) {
//            case FIRSTNAME:  fieldStringDisplay = "First Name"; break;
//            case LASTNAME: fieldStringDisplay = "Last Name"; break;
//            case USERNAME: fieldStringDisplay = "User Name"; break;
//            case PASSWORD: fieldStringDisplay = "Password"; break;
//            case CONSOLE: fieldStringDisplay = "Console"; break;
//        }
//        return getStringInput(fieldStringDisplay);
//    }

    // This method returns string input from user dependent on field chosen.
    public static String getStringInput(UserInputFields fieldString) {
        String userString = " ";
        while (userString.isBlank()) {
            try{
                System.out.print("\nPlease Enter " + fieldString.field + ": ");
                userString = scanner.getString();
            } catch (InputMismatchException e){
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return userString;
    }

    public static void closeScanner(){
        scanner.closeScanner();
    }

//    public static String getFirstNameInput() {
//        String firstName = "";
//        while (firstName.isBlank()) {
//            System.out.print("Please Enter First Name: ");
//            firstName = scanner.getString();
//        }
//        return firstName;
//    }
//
//    public static String getLastNameInput() {
//        String lastName = "";
//        while (lastName.isBlank()) {
//            System.out.print("Please Enter Last Name: ");
//            lastName = scanner.getString();
//        }
//        return lastName;
//    }
//
//    public static String getUserNameInput() {
//        String userName = "";
//        while (userName.isBlank()) {
//            System.out.print("Please Enter UserName: ");
//            userName = scanner.getString();
//        }
//        return userName;
//    }
}
