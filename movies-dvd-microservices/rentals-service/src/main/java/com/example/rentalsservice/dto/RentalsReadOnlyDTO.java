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
public class RentalsReadOnlyDTO {
    private Long id;
    public Long movieId;
    public Long customerId;
    public double price;
//    @Enumerated(EnumType.STRING)
    public Status status;
}
