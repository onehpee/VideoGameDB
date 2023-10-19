package org.example.VideoGame;

import java.time.LocalDate;
import java.util.List;

public class FakeVideoGameDAOImp implements VideoGamesDAO {

    @Override
    public VideoGame getVideoGameByID(int id) {
        return null;
    }

    @Override
    public VideoGame getVideoGameByTitle(String title) {
        return new VideoGame(0, "Fake Video Game", "M", 50, LocalDate.now(), "GameCast");
    }

    @Override
    public List<VideoGame> getVideoGamesByRating(String rating) {
        return null;
    }

    @Override
    public List<VideoGame> getAllVideoGames() {
        return null;
    }
}
