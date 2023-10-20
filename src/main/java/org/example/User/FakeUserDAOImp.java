package org.example.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FakeUserDAOImp implements UserDAO{

    private final List<User> userList;

    public FakeUserDAOImp() {
        userList = new ArrayList<>();
    }
    @Override
    public UserDTO findByID(int id) {
        return userList.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .map(user -> new UserDTO(user.getId(), user.getUserName()))
                .orElse(null);
    }

    @Override
    public UserDTO findByUserNameAndPassword(String userName, String passWord) {
        return userList.stream()
                .filter(user -> user.getUserName().equals(userName) && user.getPassword().equals(passWord))
                .findFirst()
                .map(user -> new UserDTO(user.getId(), user.getUserName()))
                .orElse(null);
    }

    @Override
    public boolean checkIfIDExists(int id) {
        return userList.stream()
                .map(User::getId)
                .anyMatch(userID -> userID == id);
    }

    @Override
    public boolean checkIfUserNameExists(String enteredUserName) {
        return userList.stream()
                .map(User::getUserName)
                .anyMatch(userName -> userName.equals(enteredUserName));
    }

    @Override
    public boolean checkIfPasswordExists(String enterPassword) {
        return userList.stream()
                .map(User::getPassword)
                .anyMatch(password -> password.equals(enterPassword));
    }

    @Override
    public void saveUser(User newUser) {
        System.out.println(newUser);
        userList.add(newUser);
    }

}
