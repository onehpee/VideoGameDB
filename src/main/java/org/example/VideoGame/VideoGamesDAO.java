package org.example.VideoGame;

import java.util.List;

public interface VideoGamesDAO {

     VideoGame getVideoGameByID(int id);

     VideoGame getVideoGameByTitle(String title);

     List<VideoGame> getVideoGamesByRating(String rating);

     List<VideoGame> getAllVideoGames();


}
