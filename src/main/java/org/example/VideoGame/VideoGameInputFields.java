package org.example.VideoGame;

public enum VideoGameInputFields {
    TITLE("Title"),
    RATING("Rating"),

    RELEASEDATE("Release Date"),

    CONSOLE2("Console");

    public final String field;

    private VideoGameInputFields(String field){this.field=field;}
}
