package com.example.moviesdvdmicroservices.model;

import com.example.moviesdvdmicroservices.UserDTO.Credentials;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserRoleFactory extends User{
    public static User NEW_CUSTOMER(Credentials credentials) {
        User user = new User();
//        user.setIsActive(true);
        user.setRole(Role.CUSTOMER);
        user.setStatus(Status.APPROVED);
        user.setUsername(credentials.getUsername());
        user.setEmail(credentials.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(credentials.getPassword()));
        return user;
    }

    public static User NEW_EMPLOYEE(Credentials credentials) {
        User user = new User();
//        user.setIsActive(true);
        user.setRole(Role.EMPLOYEE);
        user.setStatus(Status.APPROVED);
        user.setUsername(credentials.getUsername());
        user.setEmail(credentials.getEmail());
        user.setPassword(new BCryptPasswordEncoder().encode(credentials.getPassword()));
        return user;
    }
}
