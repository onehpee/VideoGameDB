package org.example.Repo;

import org.example.VideoGame.VideoGame;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VideoGameRepo implements VideoGamesDAO {

    private final Connection connection;

    public VideoGameRepo(){
        connection = ConnectionSingleton.getConnectionSingleton("videogamedb2");
    }

    private VideoGame populateVideoGameObj(ResultSet rs) throws SQLException {
        int dbVideoGameID = rs.getInt(1);
        String dbTitle = rs.getString(3);
        String dbRating = rs.getString(4);
        double dbPrice = rs.getDouble(5);
        LocalDate dbReleaseDate = Date.valueOf(rs.getDate(6).toLocalDate()).toLocalDate();
        String dbConsole = rs.getString(7);
        return new VideoGame(dbVideoGameID, dbTitle, dbRating, dbPrice, dbReleaseDate, dbConsole);
    }


    /* ----------------------------------- SAVE OBJECT METHODS (Start) -------------------------------- */

    @Override
    public void saveGame(VideoGame videoGame, int userID) {
        String query = "INSERT INTO videogame(User_ID,Title, Rating,Price, ReleaseDate, Console) values(?,?,?,?,?,?)";
        try {
            // create the java statement
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1,userID);
            st.setString(2,videoGame.getTitle());
            st.setString(3, videoGame.getRating());
            st.setDouble(4,videoGame.getPrice());
            st.setDate(5, java.sql.Date.valueOf(videoGame.getReleaseDate()));
            st.setString(6, videoGame.getConsole());
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
    public VideoGame getVideoGameByID(int videoGameID, int userID) {
        String query = "select * from videogame where VideoGamesID=? AND User_ID=?";
        VideoGame videoGame = null;
        try {
            // create the java statement
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1,videoGameID);
            st.setInt(2,userID);
            ResultSet rs = st.executeQuery();
            if(rs.next()) videoGame = populateVideoGameObj(rs);
            st.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return videoGame;
    }

    @Override
    public VideoGame getVideoGameByTitle(String title, int userID) {
        String query = "select * from videogame where Title=? AND User_ID=?";
        VideoGame videoGame = null;
        try {
            // create the java statement
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1,title);
            st.setInt(2,userID);
            ResultSet rs = st.executeQuery();
            if(rs.next()) videoGame = populateVideoGameObj(rs);
            st.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return videoGame;
    }

    /* ----------------------------------- SELECT OBJECT METHODS (End) -------------------------------- */

    /* ----------------------------------- SELECT LIST METHODS (Start) -------------------------------- */

    @Override
    public List<VideoGame> getVideoGamesByRating(String rating, int UserID) {
        String query = "select * from videogame where Rating=? AND User_ID=?";
        return getGameList(query, rating, UserID);

    }

    @Override
    public List<VideoGame> getVideoGamesByConsole(String console, int userID) {
        String query = "select * from videogame where Console=? AND User_ID=?";
        return getGameList(query, console, userID);
    }

    @Override
    public List<VideoGame> getAllVideoGames(int userID) {
        String query = "select * from videogame where User_ID=?";
        return getGameList(query, null, userID);
    }

    private List<VideoGame> getGameList(String query, String fieldColumnName, int userID){
        List<VideoGame> videoGame = new ArrayList<>();
        boolean ifFieldDoesNotExist = (fieldColumnName == null || fieldColumnName.isBlank() || fieldColumnName.isEmpty());
        int userIDColumnNumber = ifFieldDoesNotExist ? 1 : 2;
        try {
            // create the java statement
            PreparedStatement st = connection.prepareStatement(query);
            if (!ifFieldDoesNotExist) st.setString(1, fieldColumnName);
            st.setInt(userIDColumnNumber, userID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) videoGame.add(populateVideoGameObj(rs));
            st.close();
        } catch (SQLException e) {
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return videoGame;
    }

    /* ----------------------------------- SELECT LIST METHODS (End) -------------------------------- */



    /* ------------------------------ DELETE METHODS (Start) ------------------------------------ */

    @Override
    public void deleteGameByID(int videoGameID, int userID) {
        String query = "DELETE FROM videogame WHERE VideoGamesID=? AND User_ID=?";
        try {
            // create the java statement
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1,videoGameID);
            st.setInt(2,userID);
            st.executeUpdate();
            st.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGameByTitle(String title, int userID) {
        String query = "DELETE FROM videogame WHERE Title=? AND User_ID=?";
        try {
            // create the java statement
            PreparedStatement st = connection.prepareStatement(query);
            st.setString(1,title);
            st.setInt(2,userID);
            st.execute();
            st.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllGames(int userID) {
        String query = "DELETE FROM videogame WHERE User_ID=?";
        try {
            // create the java statement
            PreparedStatement st = connection.prepareStatement(query);
            st.setInt(1,userID);
            st.execute();
            st.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }

    /* ------------------------------ DELETE METHODS (End) ------------------------------------ */
}
