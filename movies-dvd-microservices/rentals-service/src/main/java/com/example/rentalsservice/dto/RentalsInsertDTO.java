package com.example.rentalsservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RentalsInsertDTO {
    private Long movieId;
    private Long customerId;
    private double pricePerDay;
    private int days;

    @Override
    public String toString() {
        return "RentalsInsertDTO{" +
                "movieId=" + movieId +
                ", customerId=" + customerId +
                ", pricePerDay=" + pricePerDay +
                ", days=" + days +
                '}';
    }
}
