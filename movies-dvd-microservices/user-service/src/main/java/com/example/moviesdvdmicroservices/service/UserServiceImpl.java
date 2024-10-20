package com.example.moviesdvdmicroservices.service;


import com.example.moviesdvdmicroservices.Exceptions.UserNotFoundException;
import com.example.moviesdvdmicroservices.Exceptions.UsernameAlreadyExistsException;
import com.example.moviesdvdmicroservices.UserDTO.Credentials;
import com.example.moviesdvdmicroservices.UserDTO.UserUpdateDTO;
import com.example.moviesdvdmicroservices.model.Role;
import com.example.moviesdvdmicroservices.model.User;
import com.example.moviesdvdmicroservices.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.BiFunction;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements IUserService {
    private final UserRepository userRepository;
//    private final UserRoleConfig userRoleConfig;
    @Transactional
    @Override
    public User insertUser(String role, Credentials credentials) throws Exception {
        User user;


        try{
            Optional<User> userToCreate = userRepository.findByUsername(credentials.getUsername());
            if (userToCreate.isPresent()) throw new UsernameAlreadyExistsException(credentials.getUsername());
            user = Role.valueOf(role.toUpperCase()).createUser(credentials);
            user = userRepository.save(user);
            if(user.getId()==null){
                throw new Exception("Insert error");
            }
            log.info("insert success for user with id"+ user.getId());
            return user;
        }catch (Exception e){
            log.error("insert error "+ e.getMessage());
            throw e;
        }
    }

    @Transactional
    @Override
    public User updateUser(UserUpdateDTO dto) throws UserNotFoundException {
        User user;
        User userToUpdate;
        try {
            user = userRepository.findById(dto.getId()).orElseThrow(() -> new UserNotFoundException(dto.getId()));
            userToUpdate = new User(dto.getId(), dto.getUsername(),dto.getEmail(), dto.getPassword(),dto.getRole());
            userToUpdate.setPassword(new BCryptPasswordEncoder().encode(dto.getPassword()));
            user = userRepository.save(userToUpdate);
            log.info("User with id: "+ userToUpdate.getId()+ " was updated");
        }catch (UserNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return user;    }

    @Transactional
    @Override
    public User deleteUser(Long id) throws UserNotFoundException {
        User user;

        try {
            user = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
            userRepository.deleteById(id);
        }catch (UserNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return user;
    }

    @Override
    public List<User> getUsersByUsername(String username) throws UserNotFoundException {
        List<User> users = new ArrayList<>();
        try {
            users = userRepository.findByUsernameStartingWith(username);
            if (users.isEmpty()) throw new UserNotFoundException(username);
            log.info("Users with lastname starting with "+ username +" were found");
        }catch (UserNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return users;
    }

    @Override
    public User getUserById(Long id) throws UserNotFoundException {
        User user;
        try {
            user = userRepository.findUserById(id);
            if(user==null)throw new UserNotFoundException(id);
        }catch (UserNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return user;
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
//        User user;
//        try {
//            user = userRepository.findUserByUsername(username);
//            if(user==null)throw new EntityNotFoundException(User.class,0L);
//
//        }catch (EntityNotFoundException e){
//            log.error(e.getMessage());
//            throw e;
//        }

        Optional<User> user = userRepository.findByUsername(username);
        return user.orElseThrow(() -> new UserNotFoundException(username));
    }

//    @Override
//    @Transactional
//    public User promoteToAdmin(Long userId) throws UserNotFoundException {
//        User user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
//        user.setRole(Role.ADMIN);
//        userRepository.save(user);
//        return user;
//    }

}
