package com.example.moviesdvdmicroservices.model;

import com.example.moviesdvdmicroservices.UserDTO.Credentials;

public enum Role {

    /*
       abstract method createUser helps to create new user by queryParam "role" through the register post request
       If the query param is customer then create a new User instance with role value as Role.CUSTOMER and given body credentials encoded password and status details
        */
    CUSTOMER {
        @Override
        public User createUser(Credentials credentials) {
            return UserRoleFactory.NEW_CUSTOMER(credentials);
        }
    },
    EMPLOYEE {

        //        @Override
        public User createUser(Credentials credentials) {
            return UserRoleFactory.NEW_EMPLOYEE(credentials);
        }
    };

    public abstract User createUser(Credentials credentials);
}