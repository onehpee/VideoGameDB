package org.example.Repo;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConnectionSingleton {

    private static ConnectionSingleton singleton = null;
    private static Connection conn = null;

    private ConnectionSingleton() {
    }

    public static Connection getConnectionSingleton(String sqlName) {
        if (singleton == null){
            singleton = new ConnectionSingleton();
            conn = getConnection(sqlName);
        }
        return conn;
    }

    public static void closeConnectionSingleton() throws SQLException {
        if(singleton == null) return;
        try {
            conn.close();
        } catch (SQLException e) {
            throw new SQLException("Connection Not Closed");
        }
    }

    private static Connection getConnection(String sqlName){
        Map<String,String> dbInfo = readFile();
        String url = "jdbc:mysql://localhost:3306/" + sqlName;
        String username = dbInfo.get("onehpee_DBUsername");
        String password = dbInfo.get("onehpee_DBPassword");

        //System.out.println("Connecting to database...");
        try  {
            //System.out.println("Database connected!");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect to database!", e);
        }
    }


    private static Map<String,String> readFile() {
        Map<String,String> databaseinfo = new HashMap<>();
        try {
            File myObj = new File("databaseinfo.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] info = data.split(":");
                databaseinfo.put(info[0].trim(),info[1].trim());
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return databaseinfo;
    }
}
