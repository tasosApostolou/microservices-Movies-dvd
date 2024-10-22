package com.example.rentalsservice.service;

import com.example.rentalsservice.dto.RentalsInsertDTO;
import com.example.rentalsservice.exception.RentalNotFoundException;
import com.example.rentalsservice.model.Rentals;

import java.util.List;

public interface IRentalsService {
    Rentals AddNewRental(RentalsInsertDTO dto) throws Exception;
    List<Rentals> getRentalsByMovieId(Long movieId) throws RentalNotFoundException;
    List<Rentals> getRentalsByCustomerId(Long customerId) throws RentalNotFoundException;
    List<Rentals> getRentalsApproved() throws RentalNotFoundException;

}
