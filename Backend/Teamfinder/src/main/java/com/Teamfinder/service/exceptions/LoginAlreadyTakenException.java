package com.Teamfinder.service.exceptions;

public class LoginAlreadyTakenException extends RuntimeException {
    public LoginAlreadyTakenException(String message) {
        super(message);
    }
}
