package com.example.moviesdvdmicroservices.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserRegisterDTO {
    //    @NotBlank
    private String username;
    //    @NotBlank
    private String password;
    //    @NotBlank
    private String email;
}