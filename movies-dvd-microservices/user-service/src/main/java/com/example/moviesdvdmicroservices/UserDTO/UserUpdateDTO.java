package com.example.moviesdvdmicroservices.UserDTO;


import com.example.moviesdvdmicroservices.model.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserUpdateDTO {
    private Long id;

    //    @NotBlank
    private String username;
    private String email;
    //    @NotBlank
    private String password;
    //    @NotBlank
    @Enumerated(EnumType.STRING)
    private Role role;

}
