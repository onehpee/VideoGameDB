package org.example.Menu;

public enum MenuFields {

    MAIN("Main Menu"),
    USER_MENU("User Menu"),
    SEARCH("Search"),
    DELETE("Delete"),
    DISPLAY("Display");

    public final String field;

    private MenuFields(String field){ this.field = field; }

}
