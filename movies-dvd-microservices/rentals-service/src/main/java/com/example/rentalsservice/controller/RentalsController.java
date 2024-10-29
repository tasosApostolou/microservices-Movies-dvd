package com.example.rentalsservice.controller;

import com.example.rentalsservice.mapper.Mapper;
import com.example.rentalsservice.dto.RentalsInsertDTO;
import com.example.rentalsservice.dto.RentalsReadOnlyDTO;
import com.example.rentalsservice.exception.RentalNotFoundException;
import com.example.rentalsservice.model.Rentals;
import com.example.rentalsservice.service.IRentalsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/rental")
public class RentalsController {
    private final IRentalsService rentalsService;

    @PostMapping("/add")
    public ResponseEntity<RentalsReadOnlyDTO> addRental(@RequestBody RentalsInsertDTO insertDTO, @RequestHeader("Authorization") String token){

        Rentals rental;
        try{

            rental = rentalsService.AddNewRental(insertDTO);
//            RentalsReadOnlyDTO readOnlyDTO = new RentalsReadOnlyDTO(rental.getId(),rental.getMovieId(), rental.getCustomerId(), rental.getPrice(), rental.getStatus());
            RentalsReadOnlyDTO readOnlyDTO = Mapper.mapToReadOnlyDTO(rental);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(readOnlyDTO.getId())
                    .toUri();
            return ResponseEntity.created(location).body(readOnlyDTO);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @GetMapping("/movie/{movieID}")
    public ResponseEntity<List<RentalsReadOnlyDTO>> getMovieRentals(@PathVariable("movieID") Long movieID){
        List<Rentals> rentals;
        List<RentalsReadOnlyDTO> rentalsReadOnlyDTO = new ArrayList<>();
        try{
            rentals = rentalsService.getRentalsByMovieId(movieID);
            rentals.forEach(rental -> rentalsReadOnlyDTO.add(new RentalsReadOnlyDTO()));
        }catch (RentalNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(rentalsReadOnlyDTO, HttpStatus.OK);
    }

    @GetMapping("/customer/{customerID}")
    public ResponseEntity<List<RentalsReadOnlyDTO>> getCustomerRentals(@PathVariable("customerID") Long customerID){
        List<Rentals> rentals;
        List<RentalsReadOnlyDTO> rentalsReadOnlyDTO = new ArrayList<>();
        try{
            rentals = rentalsService.getRentalsByCustomerId(customerID);
            rentals.forEach(rental -> rentalsReadOnlyDTO.add(Mapper.mapToReadOnlyDTO(rental)));
        }catch (RentalNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(rentalsReadOnlyDTO, HttpStatus.OK);
    }
}
