package org.example;

import org.example.Menu.MenuFields;
import org.example.Menu.UserMenu;
import org.example.User.*;

public class Main {
    public static void main(String[] args) {
        UserMenu userMenu = new UserMenu();
        UserService userService = new UserService(new FakeUserDAOImp());
        int mainMenuChoice = 0;
        while (mainMenuChoice != 3){
            mainMenuChoice = userMenu.menu(MenuFields.MAIN);
            if (mainMenuChoice == 3) break;
            UserDTO currentUser = (mainMenuChoice == 1) ? userService.loginService() : userService.registerService();
            if (currentUser != null) userService.fullService(currentUser);
        }
    }
}