package com.example.mapper;

import com.example.rentalsservice.dto.RentalsReadOnlyDTO;
import com.example.rentalsservice.model.Rentals;

public class Mapper {
    public static RentalsReadOnlyDTO mapToReadOnlyDTO(Rentals rental) {
        return new RentalsReadOnlyDTO(rental.getId(),rental.getMovieId(), rental.getCustomerId(), rental.getPrice(), rental.getStatus());

    }
}
