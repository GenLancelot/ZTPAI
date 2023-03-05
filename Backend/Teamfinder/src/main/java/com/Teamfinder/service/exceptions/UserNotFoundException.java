package com.Teamfinder.service.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super("Could not find user " + message);
    }
}