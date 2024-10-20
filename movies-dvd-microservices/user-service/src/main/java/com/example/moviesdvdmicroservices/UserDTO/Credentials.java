package com.example.moviesdvdmicroservices.UserDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Credentials {
    private String username;
    private String email;
    private String password;
}
