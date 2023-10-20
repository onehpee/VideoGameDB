package org.example.User;

import org.example.Exception.ValueExistsInDatabaseException;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    private int userID = 0;

    public UserDTO loginService() {
        System.out.println("*** LOGIN ***");
        String userName = UserInputs.getStringInput(UserInputFields.USERNAME);
        String password = UserInputs.getStringInput(UserInputFields.PASSWORD);
        return userDAO.findByUserNameAndPassword(userName, password);
    }

    public UserDTO registerService() {
        System.out.println("*** REGISTER ***");
        String firstName = UserInputs.getStringInput(UserInputFields.FIRSTNAME);
        String lastName = UserInputs.getStringInput(UserInputFields.LASTNAME);
        String userName = getValueAfterVerification(UserInputFields.USERNAME);
        String password = getValueAfterVerification(UserInputFields.PASSWORD);
        String console = UserInputs.getStringInput(UserInputFields.CONSOLE);
        User newUser = new User(++userID, firstName, lastName, userName, password,console);
        userDAO.saveUser(newUser);
        return userDAO.findByID(newUser.getId());
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

    public void print() {
        userDAO.print();
    }



    public void addService (int choice) {
        switch (choice) {
            case 1:
        }
    }


}
