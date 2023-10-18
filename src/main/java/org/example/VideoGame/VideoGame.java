package org.example.VideoGame;

import java.util.Date;

public class VideoGame {
    private int id;
    private String title;
    private String rating;
    private double price;
    private Date releaseDate;
    private String console;

    public VideoGame(int id, String title, String rating, double price, Date releaseDate, String console) {
        this.id = id;
        this.title=title;
        this.rating=rating;
        this.price=price;
        this.releaseDate=releaseDate;
        this.console = console;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }
}
