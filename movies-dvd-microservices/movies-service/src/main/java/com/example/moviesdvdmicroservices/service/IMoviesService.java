package com.example.moviesdvdmicroservices.service;


import com.example.moviesdvdmicroservices.dto.MoviesDTO.MoviesInsertDTO;
import com.example.moviesdvdmicroservices.exceptions.EntityNotFoundException;
import com.example.moviesdvdmicroservices.model.Movies;

import java.util.List;

public interface IMoviesService {
    Movies insert(MoviesInsertDTO dto) throws Exception;
    List<Movies> getMoviesByTitle(String title) throws EntityNotFoundException;
    Movies getMovieById(Long id) throws EntityNotFoundException;
    List<Movies> getAllMovies() throws EntityNotFoundException;

}
