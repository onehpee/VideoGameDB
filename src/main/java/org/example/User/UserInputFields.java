package org.example.User;

public enum UserInputFields {
    FIRSTNAME("First Name"),
    LASTNAME("Last Name"),
    USERNAME("User Name"),
    PASSWORD("Password"),
    CONSOLE("Console");

    public final String field;

    private UserInputFields(String field){ this.field = field; }
}
