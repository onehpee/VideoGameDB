package org.example;

import org.example.User.User;
import org.example.User.UserInputs;
import org.example.VideoGame.VideoGame;

import static org.example.User.UserInputs.*;
import static org.example.User.UserInputFields.*;
import static org.example.VideoGame.VideoGameInputFields.*;
import static org.example.VideoGame.VideoGameInputs.*;

public class Main {
    public static void main(String[] args) {
        int userID = getIDInput();
        String firstName = getStringInput(FIRSTNAME);
        String lastName = getStringInput(LASTNAME);
        String userName = getStringInput(USERNAME);
        String passWord = getStringInput(PASSWORD);
        String console = getStringInput(CONSOLE);

        int gameID = getVideoGameIDInput();
        double price = getPrice();
        String title = getStringInput2(TITLE);
        String rating = getStringInput2(RATING);
        String releaseDate = getStringInput2(RELEASEDATE);
        String console2 = getStringInput2(CONSOLE2);

        System.out.println("\nMade User With The Following Values: \n");
        System.out.println(new User(userID, firstName, lastName, userName, passWord, console));
        System.out.println("\nMade Video Game With The Following Values: \n");
        System.out.println(new VideoGame(gameID,title, rating,price,releaseDate, console2));
    }
}