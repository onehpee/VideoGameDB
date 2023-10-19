package org.example;

import org.example.Menu.MenuFields;
import org.example.Menu.UserMenu;
import org.example.User.User;
import org.example.User.UserInputs;
import org.example.User.UserService;
import org.example.VideoGame.VideoGame;
import org.example.User.UserDTO;
import org.example.VideoGame.VideoGameService;

import java.time.LocalDate;

import static org.example.User.UserInputs.*;
import static org.example.User.UserInputFields.*;
import static org.example.VideoGame.VideoGameInputFields.*;
import static org.example.VideoGame.VideoGameInputs.*;

public class Main {
    public static void main(String[] args) {
//        UserMenu userMenu = new UserMenu();
//        UserService userService = new UserService();
//        userService.registerService();
//        int mainMenuChoice = 0;
//        while (mainMenuChoice != 3){
//            mainMenuChoice = userMenu.menu(MenuFields.MAIN);
//            if (mainMenuChoice == 3) break;
//            UserDTO currentUser = (mainMenuChoice == 1) ? userService.loginService() : userService.registerService();
//            if (currentUser != null) userMenu.profileUserMenu(currentUser.userName());
//        }

        VideoGameService videoGameService = new VideoGameService();
        VideoGame videoGame[] = {
                new VideoGame(11, "CS:GO", "M", 7.40, LocalDate.of(1993, 01, 03), "Dumb Ass PC"),
                new VideoGame(12, "Prince of Persia", "T", 50.34, LocalDate.now(), "Xbox"),
                new VideoGame(10, "SSX 3", "E", 30.87, LocalDate.now(), "Playstation 2"),
                new VideoGame(3, "Devil May Cry", "M", 70.52, LocalDate.now(), "Playstation 2"),
                new VideoGame(5, "Call of Duty: Modern Warfare", "M", 100.89, LocalDate.now(), "Xbox360"),
                new VideoGame(2, "God Of War", "M", 50.00, LocalDate.now(), "Playstation"),
                new VideoGame(4, "The Incredible Hulk: Ultimate Destruction", "T", 34.45, LocalDate.now(), "LameCube"),
                new VideoGame(1, "Super Mario World", "E", 40.00, LocalDate.now(), "Nintendo Switch"),
        };
            for(VideoGame v: videoGame) videoGameService.addNewGame(v);

            videoGameService.displayService();

        }
}