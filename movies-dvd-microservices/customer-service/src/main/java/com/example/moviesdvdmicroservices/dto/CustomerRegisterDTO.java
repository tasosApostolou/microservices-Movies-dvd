package com.example.moviesdvdmicroservices.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRegisterDTO {
//    @NotNull
    private String username;
    private String email;
    private String password;
//    @NotNull
    private String firstname;
//    @NotNull
    private String lastname;
}