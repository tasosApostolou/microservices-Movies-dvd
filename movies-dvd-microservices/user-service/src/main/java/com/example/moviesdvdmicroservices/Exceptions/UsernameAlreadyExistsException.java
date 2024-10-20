package com.example.moviesdvdmicroservices.Exceptions;

public class UsernameAlreadyExistsException extends Exception{
    private static final long serialVersionUID = 2L;

    public UsernameAlreadyExistsException(String username) {
        super("user  with username" + username + " already exists");
    }
}
