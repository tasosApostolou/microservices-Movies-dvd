package com.example.rentalsservice.dto;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    public Long customerId;
    public String firstname;
    public String lastname;
    public String email;
}
