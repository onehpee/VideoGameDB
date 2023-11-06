package org.example.Repo;

import org.example.User.User;
import org.example.User.UserDTO;

public interface UserDAO {

        UserDTO findByID(int id);

        UserDTO findByUserNameAndPassword(String userName, String passWord);

        boolean checkIfIDExists(int id);

        boolean checkIfUserNameExists(String userName);

        boolean checkIfPasswordExists(String passWord);

        void saveUser(User newUser);

}
