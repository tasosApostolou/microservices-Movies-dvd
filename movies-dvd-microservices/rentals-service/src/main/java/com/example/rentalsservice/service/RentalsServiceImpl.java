package com.example.rentalsservice.service;
import com.example.moviesdvdmicroservices.event.RentalPlaceEvent;
import com.example.rentalsservice.client.CustomerClient;
import com.example.rentalsservice.client.InventoryClient;
import com.example.rentalsservice.dto.CustomerResponseDTO;
import com.example.rentalsservice.dto.RentalsInsertDTO;
import com.example.rentalsservice.exception.RentalNotFoundException;
//import com.example.rentalsservice.model.CustomerDetails;
//import com.example.rentalsservice.model.MovieDetails;
import com.example.rentalsservice.model.Rentals;
import com.example.rentalsservice.model.Status;
import com.example.rentalsservice.repository.RentalsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RentalsServiceImpl implements IRentalsService{
    private final RentalsRepository rentalsRepository;
    private final InventoryClient inventoryClient;
    private final CustomerClient customerClient;
    private final KafkaTemplate<String, RentalPlaceEvent> kafkaTemplate;

    //    private final MoviesRepository moviesRepository;
//    private final CustomerRepository customerRepository;
    @Override
    @Transactional
    public Rentals AddNewRental(RentalsInsertDTO dto) throws Exception {

        Rentals rental;
//        MovieDetails movie;
//        CustomerDetails customer;
        System.out.println(inventoryClient.rentalRequest(dto.getMovieId()));

        try{
            boolean rentalRequest = inventoryClient.rentalRequest(dto.getMovieId());
            System.out.println("pro rental"+rentalRequest);

            if(rentalRequest){
                //Status APPROVED
                rental = new Rentals(null,dto.getCustomerId(), dto.getMovieId(), dto.getDays(), dto.getPricePerDay()* dto.getDays(),Status.APPROVED);
            }else{
                // STATUS REJECTED
                rental = new Rentals(null,dto.getCustomerId(), dto.getMovieId(), dto.getDays(), dto.getPricePerDay()* dto.getDays(),Status.APPROVED);

            }
            rental = rentalsRepository.save(rental);
            CustomerResponseDTO customerDTO = customerClient.getCustomer(rental.getCustomerId());
            RentalPlaceEvent rentalPlaceEvent = new  RentalPlaceEvent();
            rentalPlaceEvent.setId(rental.getId().toString());
            rentalPlaceEvent.setEmail(customerDTO.getEmail());
            rentalPlaceEvent.setFirstname(customerDTO.getFirstname());
            rentalPlaceEvent.setLastname(customerDTO.getLastname());
            rentalPlaceEvent.setDays(String.valueOf(rental.getDays()));
            rentalPlaceEvent.setPrice(String.valueOf(rental.getPrice()));
            rentalPlaceEvent.setStatus(String.valueOf(rental.getStatus()));
            kafkaTemplate.send("rental-placed",rentalPlaceEvent);

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
