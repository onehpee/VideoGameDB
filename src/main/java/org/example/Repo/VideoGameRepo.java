package org.example.Repo;

import org.example.VideoGame.VideoGame;
import org.example.VideoGame.VideoGamesDAO;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class VideoGameRepo extends RepoInfo implements VideoGamesDAO {
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
    public void saveGame(VideoGame videoGame, int userID) {
        String query = "INSERT INTO videogame2(UserID,Title, Rating,Price,Console) values(?,?,?,?,?)";
        Connection conn = getConnection();
        int day = videoGame.getReleaseDate().getDayOfMonth();
        int month = videoGame.getReleaseDate().getMonthValue();
        int year = videoGame.getReleaseDate().getYear();
        Date date = new Date(year,month,day);
        try {
            // create the java statement
            PreparedStatement st = conn.prepareStatement(query);
            st.setInt(1,userID);
            st.setString(2,videoGame.getTitle());
            st.setString(3, videoGame.getRating());
            st.setDouble(4,videoGame.getPrice());
          //  st.setDate(5, date);
            st.setString(5, videoGame.getConsole());
            st.execute();
            conn.close();
        }catch (SQLException e){
            // System.out.println("Error Caught: " + e.printStackTrace(););
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        VideoGameRepo videoGameRepo = new VideoGameRepo();
        videoGameRepo.saveGame(new VideoGame(1,"Tetris", "M", 5.99, LocalDate.now(), "xbox"), 1);
    }

    @Override
    public VideoGame getVideoGameByID(int videoGameID, int userID) {
        return null;
    }

    @Override
    public VideoGame getVideoGameByTitle(String title, int userID) {
        return null;
    }

    @Override
    public List<VideoGame> getVideoGamesByRating(String rating, int UserID) {
        return null;
    }

    @Override
    public List<VideoGame> getVideoGamesByConsole(String console, int userID) {
        return null;
    }

    @Override
    public List<VideoGame> getAllVideoGames(int userID) {
        return null;
    }

    @Override
    public void deleteGameByID(int videoGameID, int userID) {

    }

    @Override
    public void deleteGameByTitle(String title, int userID) {

    }

    @Override
    public void deleteAllGames(int userID) {

    }
}
