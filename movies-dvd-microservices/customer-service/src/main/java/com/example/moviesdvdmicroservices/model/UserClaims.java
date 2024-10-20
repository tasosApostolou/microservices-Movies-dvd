package com.example.moviesdvdmicroservices.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor(force = true)
@Builder
@Getter
@Setter
@Entity
//public record UserClaims(@Id Long id, String Username, String role) {

public class UserClaims {
    @Id
    private Long userId;
    private String username;
    private String email;
    private String role;

    @OneToOne(mappedBy = "userClaims",cascade = CascadeType.ALL)
    private Customer customer;

    public UserClaims(long userId, String username, String email, String role) {
        this.userId=userId;
        this.username=username;
        this.email = email;
        this.role=role;
    }
}
