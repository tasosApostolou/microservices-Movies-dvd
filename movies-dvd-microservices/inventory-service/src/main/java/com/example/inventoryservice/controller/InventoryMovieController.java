package com.example.inventoryservice.controller;

import com.example.inventoryservice.dto.AddMovieResponse;
import com.example.inventoryservice.dto.ResponseForRentalRequest;
import com.example.inventoryservice.exception.MovieNotFoundException;
import com.example.inventoryservice.model.InventoryMovie;
import com.example.inventoryservice.service.IInventoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/inventory")
public class InventoryMovieController {
    private final IInventoryService inventoryService;

    @GetMapping("/available/{movieId}")
    public boolean isAvailableByMovieId(@PathVariable("movieId") Long movieId) {
        boolean available = false;

        try {
            available = inventoryService.isAvailable(movieId);

        } catch (MovieNotFoundException e) {
            e.getMessage();
        }
        return available;
    }


    @PostMapping
    public boolean rentalRequest(@RequestParam Long movieId) throws MovieNotFoundException {
       try {
           return inventoryService.rentalRequest(movieId);
       }catch (MovieNotFoundException e){
           e.getMessage();
           return false;
       }
    }

    @PostMapping("/add")
    public ResponseEntity<AddMovieResponse> AddNewMovieToInventory(@RequestParam Long movieId,@RequestParam int quantity) {
        try {
            AddMovieResponse movieResponse = inventoryService.NewMovieRequest(movieId,quantity);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(movieResponse.getMovieId())
                    .toUri();
            return ResponseEntity.created(location).body(movieResponse);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}