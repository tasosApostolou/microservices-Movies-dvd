package com.example.moviesdvdmicroservices.exceptions;

public class EntityNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public EntityNotFoundException(Class<?> entityClass, Long id) {
        super("Entity "+ entityClass.getSimpleName()+ " with id "+ id + " was not found");
    }
}
