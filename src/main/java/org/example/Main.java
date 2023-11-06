package org.example;

import org.example.Menu.MenuFields;
import org.example.Menu.UserMenu;
import org.example.Repo.ConnectionSingleton;
import org.example.Repo.UserRepo;
import org.example.User.*;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        UserMenu userMenu = new UserMenu();
        UserService userService = new UserService(new UserRepo());
        while (true){
            System.out.println("********* BASED VIDEO GAME DATABASE **********");
            int mainMenuChoice = userMenu.menu(MenuFields.MAIN);
            if (mainMenuChoice == 3) break;
            UserDTO currentUser = (mainMenuChoice == 1) ? userService.loginService() : userService.registerService();
            if (currentUser != null) userService.fullService(currentUser);
        }
        try {
            ConnectionSingleton.closeConnectionSingleton();
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }
}