package org.example.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private List<User> users = new ArrayList<>();
    private int userID = 0;

    public UserDTO loginService() {
        System.out.println("*** LOGIN ***");
        String userName = UserInputs.getStringInput(UserInputFields.USERNAME);
        String password = UserInputs.getStringInput(UserInputFields.PASSWORD);
        return getLoginUser(userName, password);
    }

    public UserDTO registerService() {
        System.out.println("*** REGISTER ***");
        String firstName = UserInputs.getStringInput(UserInputFields.FIRSTNAME);
        String lastName = UserInputs.getStringInput(UserInputFields.LASTNAME);
        String userName = UserInputs.getStringInput(UserInputFields.USERNAME);
        String password = UserInputs.getStringInput(UserInputFields.PASSWORD);
        String console = UserInputs.getStringInput(UserInputFields.CONSOLE);
        User newUser = new User(++userID, firstName, lastName, userName, password,console);
        registerUser(newUser);
        return getUserByID(userID);
    }

    public void addService (int choice) {
        switch (choice) {
            case 1:
        }
    }
    private UserDTO getLoginUser(String userName, String password) {
        return users.stream()
                .filter(user -> user.getUserName().equals(userName) && user.getPassword().equals(password))
                .findFirst()
                .map(user -> new UserDTO(user.getId(), userName))
                .orElse(null);
    }

    private void registerUser(User registeredUser){
        users.add(registeredUser);
    }

    public UserDTO getUserByID(int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .map(user -> new UserDTO(id, user.getUserName()))
                .orElse(null);
    }



}
