package com.example.moviesdvdmicroservices.repository;

import com.example.moviesdvdmicroservices.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DirectorsRepository extends JpaRepository<Director, Long> {
   Director findDirectorById(Long id);
   List<Director> findByLastnameStartingWith(String lastname);

   Optional<Director> findByFirstnameAndLastname(String firstname, String lastname);

}
