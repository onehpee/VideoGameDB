package org.example.User;

import org.example.Exception.ValueExistsInDatabaseException;
import org.example.Menu.UserMenu;
import org.example.Repo.VideoGameRepo;
//import org.example.VideoGame.FakeVideoGameDAOImp;
import org.example.VideoGame.VideoGameService;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;
    private final VideoGameService videoGameService;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
        this.videoGameService = new VideoGameService(new VideoGameRepo());
    }

    public UserDTO loginService() {
        System.out.println("\n*** LOGIN ***");
        String userName = UserInputs.getStringInput(UserInputFields.USERNAME);
        String password = UserInputs.getStringInput(UserInputFields.PASSWORD);
        return userDAO.findByUserNameAndPassword(userName, password);
    }

    public UserDTO registerService() {
        System.out.println("\n*** REGISTER ***");
        String firstName = UserInputs.getStringInput(UserInputFields.FIRSTNAME);
        String lastName = UserInputs.getStringInput(UserInputFields.LASTNAME);
        String userName = getValueAfterVerification(UserInputFields.USERNAME);
        String password = getValueAfterVerification(UserInputFields.PASSWORD);
        String console = UserInputs.getStringInput(UserInputFields.CONSOLE);
        User newUser = new User(firstName, lastName, userName, password,console);
        userDAO.saveUser(newUser);
        return userDAO.findByUserNameAndPassword(newUser.getUserName(), newUser.getPassword());
    }

    public void fullService(UserDTO userDTO) {
        UserMenu menu = new UserMenu();
        int choice = 0;
        while (choice != 5){
            choice = menu.profileUserMenu(userDTO.userName());
            switchPath(choice, menu, userDTO);
        }
    }

    private void switchPath(int choice, UserMenu menu, UserDTO userDTO) {
        switch (choice) {
            case 1: videoGameService.addService(userDTO); break;
            case 2: videoGameService.searchService(userDTO, menu); break;
            case 3: videoGameService.deleteService(userDTO, menu); break;
            case 4: videoGameService.displayService(userDTO, menu); break;
        }
    }

    private String getValueAfterVerification(UserInputFields field) {
        boolean exists = true;
        String value = "";
        while (exists) {
            try {
                value = UserInputs.getStringInput(field);
                exists = checkDatabase(field, value);
            } catch (Exception e) {
                System.err.println("WARNING: " + e.getMessage());
                System.out.println();
            }
        }
        return value;
    }

    private boolean checkDatabase (UserInputFields field, String value) {
       boolean exists = (field == UserInputFields.USERNAME) ?
                userDAO.checkIfUserNameExists(value) :
                userDAO.checkIfPasswordExists(value);
        if(exists) throw new ValueExistsInDatabaseException(field.field, value);
        return exists;
    }
}
