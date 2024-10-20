package com.example.moviesdvdmicroservices.Exceptions;

public class UserNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(Long id) {
        super("user  with id " + id + " was not found");
    }
    public UserNotFoundException(String username) {
        super("user  with username " + username + " was not found");
    }
}
