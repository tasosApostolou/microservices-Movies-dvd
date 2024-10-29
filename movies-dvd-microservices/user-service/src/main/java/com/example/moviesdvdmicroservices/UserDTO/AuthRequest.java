package com.example.moviesdvdmicroservices.UserDTO;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
//@Getter
//@Setter
@Data
public class AuthRequest {
    private String username;
    private String password;
}
