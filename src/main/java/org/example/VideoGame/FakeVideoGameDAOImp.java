package org.example.VideoGame;

import org.example.User.FakeUserDAOImp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FakeVideoGameDAOImp implements VideoGamesDAO {


    private final List<VideoGame> videoGames;

    public FakeVideoGameDAOImp() {
        videoGames = new ArrayList<>();
    }

    @Override
    public void saveGame(VideoGame videoGame) {
        videoGames.add(videoGame);
    }

    @Override
    public VideoGame getVideoGameByID(int videoGameID) {
        return videoGames.stream()
                .filter(game -> game.getId() == videoGameID)
                .findFirst()
                .orElse(null);
    }

    @Override
    public VideoGame getVideoGameByTitle(String title) {
        return videoGames.stream()
                .filter(game -> game.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<VideoGame> getVideoGamesByRating(String rating) {
        return videoGames.stream()
                .filter(game -> game.getRating().equals(rating))
                .collect(Collectors.toList());
    }

    @Override
    public List<VideoGame> getVideoGamesByConsole(String console) {
        return videoGames.stream()
                .filter(game -> game.getConsole().equals(console))
                .collect(Collectors.toList());
    }

    @Override
    public List<VideoGame> getAllVideoGames() {
        return videoGames;
    }

    @Override
    public void deleteGameByID(int videoGameID) {
        VideoGame videoGame = getVideoGameByID(videoGameID);
        videoGames.remove(videoGame);
    }

    @Override
    public void deleteGameByTitle(String title) {
        VideoGame videoGame = getVideoGameByTitle(title);
        videoGames.remove(videoGame);
    }

    @Override
    public void deleteAllGames() {
        int size = videoGames.size();
        for (int i = 0; i < size; i++){
            videoGames.remove(i);
        }
    }
}
