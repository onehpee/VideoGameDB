package org.example.Repo;

import org.example.VideoGame.VideoGame;

import java.util.List;

public interface VideoGamesDAO {

     void saveGame(VideoGame videoGame, int userID);

     VideoGame getVideoGameByID(int videoGameID, int userID);

     VideoGame getVideoGameByTitle(String title, int userID);

     List<VideoGame> getVideoGamesByRating(String rating, int UserID);

     List<VideoGame> getVideoGamesByConsole(String console, int userID);

     List<VideoGame> getAllVideoGames(int userID);

     void deleteGameByID(int videoGameID, int userID);

     void deleteGameByTitle(String title, int userID);

     void deleteAllGames(int userID);


}
