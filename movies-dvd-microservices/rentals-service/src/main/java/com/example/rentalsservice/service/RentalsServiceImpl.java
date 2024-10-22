package com.example.rentalsservice.service;
import com.example.rentalsservice.client.InventoryClient;
import com.example.rentalsservice.dto.RentalsInsertDTO;
import com.example.rentalsservice.exception.RentalNotFoundException;
//import com.example.rentalsservice.model.CustomerDetails;
//import com.example.rentalsservice.model.MovieDetails;
import com.example.rentalsservice.model.Rentals;
import com.example.rentalsservice.model.Status;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentalsServiceImpl implements IRentalsService{
    private final RentalsRepository rentalsRepository;
    private final InventoryClient inventoryClient;
//    private final MoviesRepository moviesRepository;
//    private final CustomerRepository customerRepository;
    @Override
    @Transactional
    public Rentals AddNewRental(RentalsInsertDTO dto) throws Exception {
        Rentals rental;
//        MovieDetails movie;
//        CustomerDetails customer;

        try{
            boolean rentalRequest = inventoryClient.rentalRequest(dto.getMovieId());
            if(rentalRequest){
                //Status APPROVED
                rental = new Rentals(null,dto.getCustomerId(), dto.getMovieId(), dto.getDays(), dto.getPricePerDay()* dto.getDays(),Status.APPROVED);
            }else{
                // STATUS REJECTED
                rental = new Rentals(null,dto.getCustomerId(), dto.getMovieId(), dto.getDays(), dto.getPricePerDay()* dto.getDays(),Status.APPROVED);

            }
            log.info("New rental for movie with id"+ dto.getMovieId());
            System.out.println(rental.toString());
        }catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
        System.out.println(rental.toString());
        return rental;
    }

    @Override
    public List<Rentals> getRentalsByMovieId(Long movieId) throws RentalNotFoundException {
        return rentalsRepository.findRentalsByMovieIdAndStatus(movieId,Status.APPROVED);
    }

    @Override
    public List<Rentals> getRentalsByCustomerId(Long customerId) throws RentalNotFoundException {
        return rentalsRepository.findRentalsByCustomerIdAndStatus(customerId,Status.APPROVED);
    }

    @Override
    public List<Rentals> getRentalsApproved() throws RentalNotFoundException {
        return rentalsRepository.findRentalsByStatus(Status.APPROVED);
    }
}
