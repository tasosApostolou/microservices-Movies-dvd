package com.example.inventoryservice.service;

import com.example.inventoryservice.dto.AddMovieResponse;
import com.example.inventoryservice.exception.MovieNotFoundException;

public interface IInventoryService
{
    boolean isAvailable(Long movieId) throws MovieNotFoundException;

    boolean rentalRequest(Long movieId) throws MovieNotFoundException;

//    AddMovieRequest increaseUpdate(Long movieId);

//    AddMovieRequest NewMovieRequest(AddMovieRequest movieRequest);
AddMovieResponse NewMovieRequest(Long movieId, int quantity);

}
