package org.example.Repo;

import org.example.User.User;
import org.example.User.UserDAO;
import org.example.User.UserDTO;
import org.example.User.UserService;

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
      // new UserRepo().saveUser(new User(1,"Ade","Uwen", "Mysterio619","619", "PS5"));
      //  new UserRepo().saveUser(new User(2,"Uyi","Omofonmwan", "Africanking","555", "PS2"));
      //  new UserRepo().saveUser(new User(3,"Lil","Wayne", "Weezy","444", "Xbox"));
      // System.out.println(new UserRepo().findByUserNameAndPassword("Mysterio619", "619"));
      //  System.out.println(new UserRepo().findByID());
       //System.out.println(new UserRepo().checkIfIDExists(1));
      // System.out.println(new UserRepo().checkIfUserNameExists("Mysterio619"));
       // System.out.println(new UserRepo().checkIfPasswordExists("555"));
    }

    @Override
    public UserDTO findByID(int id) {
        String query = "select * from user where UserID=?";
        Connection conn = getConnection();
        UserDTO userDTO = null;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                String dbUserName = rs.getString(4);
                userDTO = new UserDTO(id,dbUserName);
            }
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return userDTO;
    }

    @Override
    public UserDTO findByUserNameAndPassword(String userName, String passWord) {
        String query = "select * from user where UserName= ? AND Password = ?";
        Connection conn = getConnection();
        UserDTO userDTO = null;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,userName);
            st.setString(2,passWord);
            ResultSet rs = st.executeQuery();
            if (rs.next()){
                int dbUserID = rs.getInt(1);
                userDTO = new UserDTO(dbUserID,userName);
            }
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return userDTO;
    }

    @Override
    public boolean checkIfIDExists(int id) {
        String query = "SELECT UserID FROM User WHERE EXISTS(SELECT UserID FROM User WHERE UserID=?)" ;
        Connection conn = getConnection();
        boolean test = false;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();
            test = rs.next();
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return test;
    }

    @Override
    public boolean checkIfUserNameExists(String userName) {
        String query = "SELECT UserName FROM User as U WHERE EXISTS(SELECT UserName FROM user WHERE U.UserName=?)" ;
        Connection conn = getConnection();
        boolean test = false;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,userName);
            ResultSet rs = st.executeQuery();
            test = rs.next();
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return test;
    }

    @Override
    public boolean checkIfPasswordExists(String passWord) {
        String query = "SELECT Password FROM user WHERE EXISTS(SELECT Password FROM user WHERE Password=?)";
        Connection conn = getConnection();
        boolean test = false;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,passWord);
            ResultSet rs = st.executeQuery();
            test = rs.next();
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return test;
    }

}
