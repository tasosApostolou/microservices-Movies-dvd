package com.example.moviesdvdmicroservices.repository;

import com.example.moviesdvdmicroservices.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<Actor, Long> {
    Actor findActorById(Long id);
    List<Actor> findActorByLastnameStartingWith(String lastname);

    Optional<Actor> findByFirstnameAndLastname(String firstname, String lastname);

}
