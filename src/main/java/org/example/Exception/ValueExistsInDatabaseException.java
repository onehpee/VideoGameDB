package org.example.Exception;

public class ValueExistsInDatabaseException extends RuntimeException {

    public ValueExistsInDatabaseException(String field, String value) {
        super("The " + field + ": " + value + " Already Exists In Database!");
    }
}
