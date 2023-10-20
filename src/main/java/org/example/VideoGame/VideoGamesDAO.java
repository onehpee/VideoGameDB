package org.example.VideoGame;

import java.util.List;

public interface VideoGamesDAO {

     void saveGame(VideoGame videoGame);

     VideoGame getVideoGameByID(int videoGameID);

     VideoGame getVideoGameByTitle(String title);

     List<VideoGame> getVideoGamesByRating(String rating);

     List<VideoGame> getVideoGamesByConsole(String console);

     List<VideoGame> getAllVideoGames();

     void deleteGameByID(int videoGameID);

     void deleteGameByTitle(String title);

     void deleteAllGames();


}
