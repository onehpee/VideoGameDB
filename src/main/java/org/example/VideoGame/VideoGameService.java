package org.example.VideoGame;

import org.example.Menu.MenuFields;
import org.example.Menu.UserMenu;
import org.example.Repo.VideoGamesDAO;
import org.example.User.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class VideoGameService {

    private final VideoGamesDAO videoGames;

    public VideoGameService(VideoGamesDAO videoGames) {
        this.videoGames = videoGames;
    }

    public void addService(UserDTO userDTO){
        System.out.println("*** Add Game ***");
        String title = VideoGameInputs.getStringInput2(VideoGameInputFields.TITLE);
        String rating = VideoGameInputs.getStringInput2(VideoGameInputFields.RATING);
        double price = VideoGameInputs.getPrice();
        LocalDate releaseDate = VideoGameInputs.getDateInput();
        String console = VideoGameInputs.getStringInput2(VideoGameInputFields.CONSOLE2);
        videoGames.saveGame(new VideoGame(title, rating, price, releaseDate, console), userDTO.userID());
    }

    public void searchService(UserDTO userDTO, UserMenu userMenu) {
        int choice = 0;
        while (choice != 3){
            choice = userMenu.menu(MenuFields.SEARCH);
            if (choice == 3) break;
            VideoGame searchVideoGame = (choice == 1) ? searchByID(userDTO.userID()) : searchByTitle(userDTO.userID());
            displayVideoGame(searchVideoGame);
        }
    }

    public void deleteService(UserDTO userDTO, UserMenu userMenu) {
        int choice = 0;
        while (choice != 4){
            choice = userMenu.menu(MenuFields.DELETE);
            if (choice == 4) break;
            else if (choice == 1) deleteGameByID(userDTO.userID());
            else if (choice == 2) deleteGameByTitle(userDTO.userID());
            else deleteAll(userDTO.userID());
        }
    }

    public void displayService(UserDTO userDTO, UserMenu userMenu) {
        int choice = 0;
        while (choice != 4) {
            choice = userMenu.menu(MenuFields.DISPLAY);
            List<VideoGame> videoGameList = null;
            if (choice == 4) break;
            else if (choice == 1) videoGameList = displayAllGames(userDTO.userID());
            else if (choice == 2) videoGameList = displayGamesByRating(userDTO.userID());
            else if (choice == 3) videoGameList = displayGamesByConsole(userDTO.userID());
            displayAllVideoGames(videoGameList);
        }
    }

    private VideoGame searchByTitle(int userId){
        System.out.println("\n*** Search (Title) ***");
        String title = VideoGameInputs.getStringInput2(VideoGameInputFields.TITLE);
        return videoGames.getVideoGameByTitle(title,userId);
    }

    private VideoGame searchByID(int userId){
        System.out.println("\n*** Search (ID) ***");
        int id = VideoGameInputs.getVideoGameIDInput();
        return videoGames.getVideoGameByID(id, userId);
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

    private void displayAllVideoGames(List<VideoGame> videoGameList) {
        if (videoGameList == null) return;
        System.out.printf("---------------------------------" +
                "-----------------------------------" +
                "-----------------------------------------------%n");
        System.out.printf("| %-5s | %-50s | %-5s | %-10s | %-6s| %-5s %n",
                "ID", "TITLE", "RATING", "  PRICE", "RELEASE DATE", "CONSOLE");
        System.out.printf("---------------------------------" +
                "-----------------------------------" +
                "-----------------------------------------------%n");
        videoGameList.stream().sorted(Comparator.comparing(VideoGame::getId)).forEach(VideoGame::displayGame);

    }

    private List<VideoGame> displayAllGames(int userID) {
        System.out.println("*** Display (All) ***\n");
        return videoGames.getAllVideoGames(userID);
    }
    private List<VideoGame> displayGamesByRating(int userID) {
        System.out.println("*** Display (Rating) ***\n");
        String rating = VideoGameInputs.getStringInput2(VideoGameInputFields.RATING);
        return videoGames.getVideoGamesByRating(rating,userID);
    }

    private List<VideoGame> displayGamesByConsole(int userID) {
        System.out.println("*** Display (Console) ***\n");
        String console = VideoGameInputs.getStringInput2(VideoGameInputFields.CONSOLE2);
        return videoGames.getVideoGamesByConsole(console, userID);
    }

    private void deleteGameByID(int userID){
        System.out.println("*** Delete (ID) ***");
        int videoGameID = VideoGameInputs.getVideoGameIDInput();
        VideoGame deleteGame = videoGames.getVideoGameByID(videoGameID,userID);
        if (deleteGame == null) return;
        videoGames.deleteGameByID(videoGameID,userID);
        System.out.println(deleteGame.getTitle() + " Has Been Removed From Database\n");
    }

    private void deleteGameByTitle(int userID){
        System.out.println("*** Delete (Title) ***");
        String videoGameTitle = VideoGameInputs.getStringInput2(VideoGameInputFields.TITLE);
        VideoGame deleteGame = videoGames.getVideoGameByTitle(videoGameTitle, userID);
        if (deleteGame == null) return;
        videoGames.deleteGameByTitle(videoGameTitle,userID);
        System.out.println(deleteGame.getTitle() + " Has Been Removed From Database\n");
    }

    private void deleteAll(int userID) {
        System.out.println("*** Delete (All) ***");
        if (videoGames.getAllVideoGames(userID) == null) System.out.println("Database Is Empty\n");
        videoGames.deleteAllGames(userID);
        System.out.println("\nDatabase Has Been Cleared\n");
    }
}
