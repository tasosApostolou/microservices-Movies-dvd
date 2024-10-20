package com.example.moviesdvdmicroservices.Exception;

public class CustomerNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException(Long id) {
        super("customer  with id " + id + " was not found");
    }

//    public CustomerNotFoundException(String lastname) {
//        super("customers  with lastname starting with " + lastname + " was not found");
//    }
}
