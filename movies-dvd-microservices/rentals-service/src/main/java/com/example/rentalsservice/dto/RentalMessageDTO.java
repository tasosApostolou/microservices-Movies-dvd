package com.example.rentalsservice.dto;

import com.example.rentalsservice.model.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalMessageDTO {
    public String firstname;
    public String lastname;
    public Long movieId;
    public String email;
    private int days;
    public double price;

}