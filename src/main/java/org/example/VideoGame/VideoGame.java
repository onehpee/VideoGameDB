package org.example.VideoGame;

import java.time.LocalDate;
import java.util.Date;

public class VideoGame {
    private int id;
    private String title;
    private String rating;
    private double price;
    private LocalDate releaseDate;
    private String console;

    public VideoGame(int id, String title, String rating, double price, LocalDate releaseDate, String console) {
        this.id = id;
        this.title=title;
        this.rating=rating;
        this.price=price;
        this.releaseDate=releaseDate;
        this.console = console;
    }

    public VideoGame(String title, String rating, double price, LocalDate releaseDate, String console){
        this.title=title;
        this.rating=rating;
        this.price=price;
        this.releaseDate=releaseDate;
        this.console=console;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }

    public String toString() {
        return "Video Game{" +
                "id=" + id +
                ", Title='" + title + '\'' +
                ", Rating='" + rating + '\'' +
                ", Price='" + price + '\'' +
                ", Release Date='" + releaseDate + '\'' +
                ", console='" + console + '\'' +
                '}';
    }

    public void displayGame(){
        System.out.printf("| %-5s | %-50s | %-6s | %-10s | %-4s | %-5s %n",
                id, title, "  " +rating, "  $"+ price, " " + releaseDate, console);
    }
}
