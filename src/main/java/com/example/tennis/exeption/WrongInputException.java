package com.example.tennis.exeption;


public class WrongInputException extends Exception {

    public WrongInputException(String message) {
        super(message);
    }
}