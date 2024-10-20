package com.example.moviesdvdmicroservices.service;



import com.example.moviesdvdmicroservices.Exceptions.UserNotFoundException;
import com.example.moviesdvdmicroservices.Exceptions.UsernameAlreadyExistsException;
import com.example.moviesdvdmicroservices.UserDTO.Credentials;
import com.example.moviesdvdmicroservices.UserDTO.UserUpdateDTO;
import com.example.moviesdvdmicroservices.model.User;

import java.util.List;

public interface IUserService {
    User insertUser(String role, Credentials credentials) throws Exception;
    User updateUser(UserUpdateDTO userDTO) throws UserNotFoundException;
    User deleteUser(Long id) throws UserNotFoundException;
    List<User> getUsersByUsername(String username) throws UserNotFoundException;
    User getUserById(Long id) throws UserNotFoundException;
    User getUserByUsername(String username) throws UserNotFoundException;
}
