package org.example;

import org.example.User.User;

import static org.example.User.UserInputFields.*;
import static org.example.User.UserInputs.*;

public class Main {
    public static void main(String[] args) {
        int ID = getIDInput();
        String firstName = getUserInput(FIRSTNAME);
        String lastName = getUserInput(LASTNAME);
        String userName = getUserInput(USERNAME);
        String password = getUserInput(PASSWORD);
        String console = getUserInput(CONSOLE);

        System.out.println("\nUser created object with the following values: \n");
        User newUserObject = new User(ID, firstName, lastName, userName, password, console);
        System.out.println(newUserObject);

        closeScanner();
    }
}