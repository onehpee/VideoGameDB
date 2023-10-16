package org.example;

import org.example.User.User;

import static org.example.User.UserInputFields.*;
import static org.example.User.UserInputs.*;

public class Main {
    public static void main(String[] args) {
        int ID = getIDInput();
        String firstName = getStringInput(FIRSTNAME);
        String lastName = getStringInput(LASTNAME);
        String userName = getStringInput(USERNAME);
        String password = getStringInput(PASSWORD);
        String console = getStringInput(CONSOLE);

        System.out.println("\nUser created object with the following values: \n");
        User newUserObject = new User(ID, firstName, lastName, userName, password, console);
        System.out.println(newUserObject);

        closeScanner();
    }
}