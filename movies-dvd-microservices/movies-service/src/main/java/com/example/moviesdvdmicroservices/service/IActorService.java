package com.example.moviesdvdmicroservices.service;


import com.example.moviesdvdmicroservices.dto.ActorDTO.ActorInsertDTO;
import com.example.moviesdvdmicroservices.exceptions.EntityNotFoundException;
import com.example.moviesdvdmicroservices.model.Actor;

import java.util.List;

public interface IActorService {
    Actor insert(ActorInsertDTO dto) throws Exception;
    List<Actor> getActorsByLastname(String lastname) throws EntityNotFoundException;
    Actor getActorById(Long id) throws EntityNotFoundException;
    List<Actor> getAllActors() throws EntityNotFoundException;

}
