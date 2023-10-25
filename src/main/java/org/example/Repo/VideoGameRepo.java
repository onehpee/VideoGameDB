package org.example.Repo;

import org.example.User.UserDTO;
import org.example.VideoGame.VideoGame;
import org.example.VideoGame.VideoGameInputFields;
import org.example.VideoGame.VideoGameInputs;
import org.example.VideoGame.VideoGamesDAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VideoGameRepo extends RepoInfo implements VideoGamesDAO {
    private Connection getConnection(){
        Map<String,String> dbInfo = readFile();
        String url = "jdbc:mysql://localhost:3306/videogamedb2";
        String username = dbInfo.get("onehpee_DBUsername");
        String password = dbInfo.get("onehpee_DBPassword");

        System.out.println("Connecting Video Game database...");
        try  {
            //System.out.println("Database connected!");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the Video game database!", e);
        }
    }



    @Override
    public void saveGame(VideoGame videoGame, int userID) {
        String query = "INSERT INTO videogame(UserID,Title, Rating,Price, ReleaseDate, Console) values(?,?,?,?,?,?)";
        Connection conn = getConnection();
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,userID);
            st.setString(2,videoGame.getTitle());
            st.setString(3, videoGame.getRating());
            st.setDouble(4,videoGame.getPrice());
            st.setDate(5, java.sql.Date.valueOf(videoGame.getReleaseDate()));
            st.setString(6, videoGame.getConsole());
            st.execute();
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        VideoGameRepo videoGameRepo = new VideoGameRepo();
//        videoGameRepo.saveGame(new VideoGame("God of War", "M", 29.99, LocalDate.now(), "Playstation 2"), 1);
//        videoGameRepo.saveGame(new VideoGame("The Last Of Us 2", "E", 84.99, LocalDate.now(), "Playstation 2"), 1);
//        videoGameRepo.saveGame(new VideoGame("Fusion Frenzy", "A", 68.99, LocalDate.now(), "Playstation 2"), 1);
//        videoGameRepo.saveGame(new VideoGame("Ninja Gaiden 2", "M", 78.99, LocalDate.now(), "Playstation 2"), 1);
//        videoGameRepo.saveGame(new VideoGame("Sonic the Hedgehog 2","M", 47.99, LocalDate.now(),"Playstation 2"),1);
       // System.out.println(videoGameRepo.getVideoGameByID(2,1));;
        //System.out.println(videoGameRepo.getVideoGameByTitle("God of War",1));
        //System.out.println(videoGameRepo.getVideoGamesByRating("M",1));
        //videoGameRepo.deleteGameByID(8,1);
        //videoGameRepo.deleteGameByTitle("The Last of Us 2",1);
        //videoGameRepo.deleteAllGames(1);
    }

    @Override
    public VideoGame getVideoGameByID(int videoGameID, int userID) {
        String query = "select * from videogame where VideoGamesID=? AND UserID=?";
        Connection conn = getConnection();
        VideoGame videoGame = null;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,videoGameID);
            st.setInt(2,userID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                int dbVideoGameID = rs.getInt(1);
                int dbUserID = rs.getInt(2);
                String dbTitle = rs.getString(3);
                String dbRating = rs.getString(4);
                Double dbPrice = rs.getDouble(5);
                LocalDate dbReleaseDate = Date.valueOf(rs.getDate(6).toLocalDate()).toLocalDate();
                String dbConsole = rs.getString(6);
                videoGame = new VideoGame(dbVideoGameID,dbTitle,dbRating,dbPrice,dbReleaseDate,dbConsole);
            }
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return videoGame;
    }

    @Override
    public VideoGame getVideoGameByTitle(String title, int userID) {
        String query = "select * from videogame where Title=? AND UserID=?";
        Connection conn = getConnection();
        VideoGame videoGame = null;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,title);
            st.setInt(2,userID);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                int dbVideoGameID = rs.getInt(1);
                int dbUserID = rs.getInt(2);
                String dbTitle = rs.getString(3);
                String dbRating = rs.getString(4);
                Double dbPrice = rs.getDouble(5);
                LocalDate dbReleaseDate = Date.valueOf(rs.getDate(6).toLocalDate()).toLocalDate();
                String dbConsole = rs.getString(6);
                videoGame = new VideoGame(dbVideoGameID,dbTitle,dbRating,dbPrice,dbReleaseDate,dbConsole);
            }
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return videoGame;
    }

    @Override
    public List<VideoGame> getVideoGamesByRating(String rating, int UserID) {
        String query = "select * from videogame where Rating=? AND UserID=?";
        Connection conn = getConnection();
        List<VideoGame> videoGame = new ArrayList<>();
        VideoGame videoGame1;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, rating);
            st.setInt(2, UserID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int dbVideoGameID = rs.getInt(1);
                int dbUserID = rs.getInt(2);
                String dbTitle = rs.getString(3);
                String dbRating = rs.getString(4);
                Double dbPrice = rs.getDouble(5);
                LocalDate dbReleaseDate = Date.valueOf(rs.getDate(6).toLocalDate()).toLocalDate();
                String dbConsole = rs.getString(6);
                videoGame1 = new  VideoGame(dbVideoGameID, dbTitle, dbRating, dbPrice, dbReleaseDate, dbConsole);
                videoGame.add(videoGame1);
            }
            conn.close();
        } catch (SQLException e) {
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return videoGame;
    }

    @Override
    public List<VideoGame> getVideoGamesByConsole(String console, int userID) {
        String query = "select * from videogame where Console=? AND UserID=?";
        Connection conn = getConnection();
        List<VideoGame> videoGame = new ArrayList<>();
        VideoGame videoGame1;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, console);
            st.setInt(2, userID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int dbVideoGameID = rs.getInt(1);
                int dbUserID = rs.getInt(2);
                String dbTitle = rs.getString(3);
                String dbRating = rs.getString(4);
                Double dbPrice = rs.getDouble(5);
                LocalDate dbReleaseDate = Date.valueOf(rs.getDate(6).toLocalDate()).toLocalDate();
                String dbConsole = rs.getString(6);
                videoGame1 = new  VideoGame(dbVideoGameID, dbTitle, dbRating, dbPrice, dbReleaseDate, dbConsole);
                videoGame.add(videoGame1);
            }
            conn.close();
        } catch (SQLException e) {
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return videoGame;
    }

    @Override
    public List<VideoGame> getAllVideoGames(int userID) {
        String query = "select * from videogame where UserID=?";
        Connection conn = getConnection();
        List<VideoGame> videoGame = new ArrayList<>();
        VideoGame videoGame1;
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1, userID);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int dbVideoGameID = rs.getInt(1);
                int dbUserID = rs.getInt(2);
                String dbTitle = rs.getString(3);
                String dbRating = rs.getString(4);
                Double dbPrice = rs.getDouble(5);
                LocalDate dbReleaseDate = Date.valueOf(rs.getDate(6).toLocalDate()).toLocalDate();
                String dbConsole = rs.getString(6);
                videoGame1 = new  VideoGame(dbVideoGameID, dbTitle, dbRating, dbPrice, dbReleaseDate, dbConsole);
                videoGame.add(videoGame1);
            }
            conn.close();
        } catch (SQLException e) {
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
        return videoGame;
    }

    @Override
    public void deleteGameByID(int videoGameID, int userID) {
        String query = "DELETE FROM videogame WHERE VideoGamesID=? AND UserID=?";
        Connection conn = getConnection();
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,videoGameID);
            st.setInt(2,userID);
            st.executeUpdate();
            System.out.println("Game with ID " + videoGameID + " Has Been Deleted");
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }

    @Override
    public void deleteGameByTitle(String title, int userID) {
        String query = "DELETE FROM videogame WHERE Title=? AND UserID=?";
        Connection conn = getConnection();
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1,title);
            st.setInt(2,userID);
            st.execute();
            System.out.println(title + " Has Been Deleted");
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAllGames(int userID) {
        String query = "DELETE FROM videogame WHERE UserID=?";
        Connection conn = getConnection();
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,userID);
            st.execute();
            System.out.println("All Games Have Been Deleted!");
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }
}
