package org.example.Repo;

import org.example.User.User;
import org.example.User.UserDTO;
import org.example.User.UserInputs;

import java.sql.*;
import java.util.Map;

public class UserRepo implements UserDAO{

    private final Connection userConnection;

    public UserRepo() {
        userConnection = ConnectionSingleton.getConnectionSingleton("videogamedb2");
    }

    /* ----------------------------------- SAVE OBJECT METHODS (Start) -------------------------------- */
    @Override
    public void saveUser(User user){
        String query = "INSERT INTO user(FirstName, LastName, UserName, Password, Console) values(?,?,?,?,?)";
        try {
            // create the java statement
            PreparedStatement st = userConnection.prepareStatement(query);
            st.setString(1,user.getFirstName());
            st.setString(2,user.getLastName());
            st.setString(3, user.getUserName());
            st.setString(4,user.getPassword());
            st.setString(5, user.getConsole());
            st.execute();
            st.close();
        }catch (SQLException e){
           // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }

    /* ----------------------------------- SAVE OBJECT METHODS (End) -------------------------------- */

    /* ----------------------------------- SELECT OBJECT METHODS (Start) -------------------------------- */
    @Override
    public UserDTO findByID(int id) {
        String query = "select USERNAME from user where UserID=?";
        UserDTO userDTO = null;
        try {
            // create the java statement
            PreparedStatement st = userConnection.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if(rs.next()) userDTO = new UserDTO(id, rs.getString(1));
            st.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return userDTO;
    }

    @Override
    public UserDTO findByUserNameAndPassword(String userName, String passWord) {
        String query = "select UserID from user where UserName= ? AND Password = ?";
        UserDTO userDTO = null;
        try {
            // create the java statement
            PreparedStatement st = userConnection.prepareStatement(query);
            st.setString(1,userName);
            st.setString(2,passWord);
            ResultSet rs = st.executeQuery();
            if (rs.next()) userDTO = new UserDTO(rs.getInt(1), userName);
            st.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return userDTO;
    }

    /* ----------------------------------- SELECT OBJECT METHODS (End) -------------------------------- */


    /* ----------------------------------- VERIFY OBJECT EXISTENCE METHODS (Start) -------------------------------- */

    @Override
    public boolean checkIfIDExists(int id) {
        String query = "SELECT UserID FROM User WHERE EXISTS(SELECT UserID FROM User WHERE UserID=?)" ;
        return checkIfInfoExistsInDatabase(query, id, null);
    }

    @Override
    public boolean checkIfUserNameExists(String userName) {
        String query = "SELECT UserName FROM User as U WHERE EXISTS(SELECT UserName FROM user WHERE U.UserName=?)" ;
        return checkIfInfoExistsInDatabase(query, 0, userName);
    }

    @Override
    public boolean checkIfPasswordExists(String passWord) {
        String query = "SELECT Password FROM user WHERE EXISTS(SELECT Password FROM user WHERE Password=?)";
        return checkIfInfoExistsInDatabase(query, 0, passWord);
    }

    private boolean checkIfInfoExistsInDatabase (String query, int id, String columnFieldName) {
        boolean ifColumnFieldIsNotPassed = (columnFieldName == null || columnFieldName.isEmpty() || columnFieldName.isBlank());
        boolean infoExists = false;
        try {
            PreparedStatement st = userConnection.prepareStatement(query);
            if (ifColumnFieldIsNotPassed) st.setInt(1, id);
            else st.setString(1, columnFieldName);
            ResultSet rs = st.executeQuery();
            infoExists = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return infoExists;
    }

    /* ----------------------------------- VERIFY OBJECT EXISTENCE METHODS (End) -------------------------------- */


}
