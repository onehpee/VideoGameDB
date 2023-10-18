package org.example.VideoGame;

public enum VideoGameInputFields {
    TITLE("Title"),
    RATING("Rating"),
    CONSOLE2("Console");

    public final String field;

    private VideoGameInputFields(String field){this.field=field;}
}
