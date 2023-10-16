package org.example;

import org.example.User.User;
import org.example.User.UserInputs;
import static org.example.User.UserInputs.*;
import static org.example.User.UserInputFields.*;

public class Main {
    public static void main(String[] args) {
        int userID = getIDInput();
        String firstName = getStringInput(FIRSTNAME);
        String lastName = getStringInput(LASTNAME);
        String userName = getStringInput(USERNAME);
        String passWord = getStringInput(PASSWORD);
        String console = getStringInput(CONSOLE);

        System.out.println("\nMade User With The Following Values: \n");
        System.out.println(new User(userID, firstName, lastName, userName, passWord, console));
    }
}