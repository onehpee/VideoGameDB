package org.example.User;

public interface UserDAO {

        UserDTO findByID(int id);
        UserDTO findByUserName(String userName);

        UserDTO findByUserNameAndPassword(String userName, String passWord);

        boolean checkIfIDExists(int it);

        boolean checkIfUserNameExists(String userName);

        boolean checkIfPasswordExists(String passWord);

        void saveUser(User newUser);

        void print();

}
