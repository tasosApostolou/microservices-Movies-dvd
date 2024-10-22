package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.AddMovieResponse;
import com.example.inventoryservice.exception.MovieNotFoundException;
import com.example.inventoryservice.model.InventoryMovie;
import com.example.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class InventorysericeImpl implements IInventoryService{
    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryMovie.class);
    private final InventoryRepository inventoryRepository;
    @Override
    public boolean isAvailable(Long movieId) throws MovieNotFoundException {
        InventoryMovie movie;
        try {
            movie = inventoryRepository.findById(movieId).orElseThrow(() -> new MovieNotFoundException(movieId));
            LOGGER.info("Availability of movie with id {} is {}", movieId,movie.isAvailable());
            return movie.isAvailable();
        }catch (MovieNotFoundException e){
            LOGGER.error("Movie with id {} not found",movieId);
            throw e;
        }
    }

    @Override
    @Transactional
    public boolean rentalRequest(Long movieId) throws MovieNotFoundException {
        InventoryMovie movie;
        boolean available;
        try {
            movie = inventoryRepository.findByMovieId(movieId).orElseThrow(() -> new MovieNotFoundException(movieId));
            available = movie.isAvailable();
            LOGGER.info("Availability of movie with id {} is {}", movieId,movie.isAvailable());
            if (available) {
                movie.setQuantity(movie.getQuantity()-1);
                return true;
            }else return false;
        }catch (MovieNotFoundException e){
            LOGGER.error("Movie with id {} not found",movieId);
            throw e;
        }    }

    @Override
    public AddMovieResponse NewMovieRequest(Long movieId, int quantity) {
        InventoryMovie movie = inventoryRepository.findInventoryMovieByMovieId(movieId);
        if(movie != null){
            movie.setQuantity(movie.getQuantity()+ quantity);
            inventoryRepository.save(movie);
        }else
        {

          movie = inventoryRepository.save(new InventoryMovie(null, movieId, quantity));
        }

        return new AddMovieResponse(movie.getMovieId(), quantity);
    }



}
