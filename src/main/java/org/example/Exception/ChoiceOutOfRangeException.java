package org.example.Exception;

public class ChoiceOutOfRangeException extends RuntimeException{

    public ChoiceOutOfRangeException(int bound){
        super("Please Pick Between 1 - " + bound);
    }
}
