package com.Teamfinder.service.exceptions;

public class InvalidPasswordException extends RuntimeException{

    public InvalidPasswordException(String message) {
        super("Password is invalid " + message);
    }
}
