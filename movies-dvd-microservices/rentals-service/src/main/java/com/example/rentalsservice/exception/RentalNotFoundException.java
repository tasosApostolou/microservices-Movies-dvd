package com.example.rentalsservice.exception;

public class RentalNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public RentalNotFoundException(Long id) {
        super("Rental with id "+ id + " was not found");
    }
}
