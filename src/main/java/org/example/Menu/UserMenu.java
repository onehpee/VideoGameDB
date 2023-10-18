package org.example.Menu;

import org.example.Scanner.MyScanner;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;

public class UserMenu extends MyScanner {

    private String[] getMenu(MenuFields field) {
        String[] menuDisplay = null;
        switch (field) {
            case MAIN: menuDisplay = new String[]{"Login", "Register", "Exit"}; break;
            case USER_MENU: menuDisplay = new String[]{"Add", "Search", "Delete", "Display", "Log Out"}; break;
            case SEARCH: menuDisplay = new String[]{"Search (ID)", "Search (Title)", "Back"}; break;
            case DELETE: menuDisplay = new String[]{"Delete (ID)", "Delete (Title)", "Delete All", "Back"}; break;
            case DISPLAY: menuDisplay = new String[]{"Display (All)", "Display (Rating)", "Display (Console)", "Back"};
        }
        return menuDisplay;
    }


    public int menu(MenuFields menuField) {
        String[] menuDisplay = getMenu(menuField);
        int menuChoice = 0;
        int bound = menuDisplay.length;
        while (menuChoice < 1 || menuChoice > bound){
            try {
                System.out.println("\n*** " + menuField.field + " ***");
                for (int i = 0; i < bound; i++){
                    System.out.println(i+1 + ". " + menuDisplay[i]);
                }
                menuChoice = getChoice(bound);
            } catch (Exception e) {
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return menuChoice;
    }

    private int getChoice(int end) {
        int choice = 0;
        System.out.print("\nEnter Choice: ");
        choice = getInt();
        System.out.println();
        if (choice < 1 || choice > end)
            throw new InputMismatchException("Please Between " + 1 + " - " + end);
        return choice;
    }

//    public int userMenu(String userName) {
//        int userMenuChoice = 0;
//        int bound = 5;
//        while (userMenuChoice < 1 || userMenuChoice > bound){
//            try {
//                System.out.println("\n*** User Menu ***");
//                System.out.println("Welcome " + userName);
//                System.out.println("1. Add");
//                System.out.println("2. Search");
//                System.out.println("3. Delete");
//                System.out.println("4. Display");
//                System.out.println("5. Log Out\n");
//                System.out.print("Enter Choice: ");
//                userMenuChoice = getChoice(1, )
//                System.out.println();
//            } catch (Exception e) {
//                System.err.println("WARNING: " + e.getMessage());
//                System.out.println();
//            }
//        }
//        return userMenuChoice;
//    }
//
//    public int searchMenu(String userName) {
//        int searchMenuChoice = 0;
//        while (searchMenuChoice < 1 || searchMenuChoice > 3){
//            try {
//                System.out.println("\n*** Search Menu ***");
//                System.out.println("Welcome " + userName);
//                System.out.println("1. Search (ID)");
//                System.out.println("2. Search (Title)");
//                System.out.println("3. Back\n");
//                System.out.print("Enter Choice: ");
//                searchMenuChoice = getInt();
//                System.out.println();
//            } catch (Exception e) {
//                System.err.println("WARNING: " + e.getMessage());
//                System.out.println();
//            }
//        }
//        return searchMenuChoice;
//    }

}
