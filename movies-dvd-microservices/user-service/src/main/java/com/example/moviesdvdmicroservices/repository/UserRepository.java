package com.example.moviesdvdmicroservices.repository;

import com.example.moviesdvdmicroservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);
    List<User> findByUsernameStartingWith(String username);
    Optional<User> findByRole(String role);
    Optional<User> findByUsername(String username);
    User findUserByUsername(String username);

}
