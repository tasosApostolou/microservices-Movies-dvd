package com.example.inventoryservice.exception;

public class MovieNotFoundException extends Exception{
    public MovieNotFoundException(Long id) {
        super("Movie with id "+ id + " was not found");

    }
}
