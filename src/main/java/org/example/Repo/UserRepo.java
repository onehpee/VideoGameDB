package org.example.Repo;

import org.example.User.User;
import org.example.User.UserDAO;
import org.example.User.UserDTO;

import java.sql.*;
import java.util.Map;

public class UserRepo extends RepoInfo implements UserDAO{
    private Connection getConnection(){
        Map<String,String> dbInfo = readFile();
        String url = "jdbc:mysql://localhost:3306/videogamedb2";
        String username = dbInfo.get("onehpee_DBUsername");
        String password = dbInfo.get("onehpee_DBPassword");

        System.out.println("Connecting database...");
        try  {
           //System.out.println("Database connected!");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    @Override
    public void saveUser(User user){
        String query = "INSERT INTO user(FirstName, LastName, UserName, Password, Console) values(?,?,?,?,?)";
        Connection conn = getConnection();
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,user.getFirstName());
            st.setString(2,user.getLastName());
            st.setString(3, user.getUserName());
            st.setString(4,user.getPassword());
            st.setString(5, user.getConsole());
            st.execute();
            conn.close();
        }catch (SQLException e){
           // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new UserRepo().saveUser(new User(1,"Ade","Uwen", "Mysterio619","619", "PS5"));
    }

    @Override
    public UserDTO findByID(int id) {
        return null;
    }

    @Override
    public UserDTO findByUserNameAndPassword(String userName, String passWord) {
        return null;
    }

    @Override
    public boolean checkIfIDExists(int id) {
        return false;
    }

    @Override
    public boolean checkIfUserNameExists(String userName) {
        return false;
    }

    @Override
    public boolean checkIfPasswordExists(String passWord) {
        return false;
    }

}
