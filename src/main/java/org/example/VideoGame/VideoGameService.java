package org.example.VideoGame;

import org.example.User.UserDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class VideoGameService {

    private List<VideoGame> videoGames = new ArrayList<>();

    private int videoGameID = 0;

    public void addService(UserDTO userDTO){
        System.out.println("*** Add Game ***");
        String title = VideoGameInputs.getStringInput2(VideoGameInputFields.TITLE);
        String rating = VideoGameInputs.getStringInput2(VideoGameInputFields.RATING);
        double price = VideoGameInputs.getPrice();
        LocalDate releaseDate = VideoGameInputs.getDateInput();
        String console = VideoGameInputs.getStringInput2(VideoGameInputFields.CONSOLE2);
        addNewGame(new VideoGame(++videoGameID, title, rating, price, releaseDate, console));
    }

    private VideoGame searchByTitle(){
        System.out.println("*** Search (Title) ***");
        String title = VideoGameInputs.getStringInput2(VideoGameInputFields.TITLE);
        return getGameByTitle(title);
    }

    private VideoGame searchByID(){
        System.out.println("*** Search (ID) ***");
        int id = VideoGameInputs.getVideoGameIDInput();
        return getGameByID(id);
    }

    public void displayService() {
        displayAllVideoGames(videoGames);
    }

    public void displayVideoGame(VideoGame videoGame) {
        if(videoGame == null) return;
        System.out.printf("---------------------------------" +
                "-----------------------------------" +
                "-----------------------------------------------%n");
        System.out.printf("| %-5s | %-50s | %-5s | %-10s | %-6s| %-5s %n",
                "ID", "TITLE", "RATING", "  PRICE", "RELEASE DATE", "CONSOLE");
        System.out.printf("---------------------------------" +
                "-----------------------------------" +
                "-----------------------------------------------%n");

        videoGame.displayGame();
    }

    private void displayAllVideoGames(List<VideoGame> videoGames) {
        System.out.printf("---------------------------------" +
                "-----------------------------------" +
                "-----------------------------------------------%n");
        System.out.printf("| %-5s | %-50s | %-5s | %-10s | %-6s| %-5s %n",
                "ID", "TITLE", "RATING", "  PRICE", "RELEASE DATE", "CONSOLE");
        System.out.printf("---------------------------------" +
                "-----------------------------------" +
                "-----------------------------------------------%n");
        videoGames.stream().sorted(Comparator.comparing(VideoGame::getId)).forEach(VideoGame::displayGame);
    }
    public void addNewGame(VideoGame newVideoGame) {
        videoGames.add(newVideoGame);
    }

    private VideoGame getGameByTitle(String title) {
        return videoGames.stream()
                .filter(game -> game.getTitle().equals(title))
                .findFirst()
                .orElse(null);
    }

    private VideoGame getGameByID(int id) {
        return videoGames.stream()
                .filter(game -> game.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
