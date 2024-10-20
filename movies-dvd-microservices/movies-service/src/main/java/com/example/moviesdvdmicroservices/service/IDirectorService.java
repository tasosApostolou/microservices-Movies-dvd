package com.example.moviesdvdmicroservices.service;


import com.example.moviesdvdmicroservices.dto.DirectorDTO.DirectorInsertDTO;
import com.example.moviesdvdmicroservices.exceptions.EntityNotFoundException;
import com.example.moviesdvdmicroservices.model.Director;

import java.util.List;

public interface IDirectorService {
    Director insert(DirectorInsertDTO dto) throws Exception;
    List<Director> getDirectorsByLastname(String lastname) throws EntityNotFoundException;
    Director getDirectorById(Long id) throws EntityNotFoundException;
    List<Director> getAllDirectors() throws Exception;
}
