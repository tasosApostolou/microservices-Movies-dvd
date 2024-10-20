package com.example.rentalsservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rentals extends AbstractEntity implements Serializable {

//    private Long customerId;
//    private Long movieId;
@Id
@ManyToOne()
@JoinColumn(name = "customer_id")
private CustomerDetails customer;

    @Id
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private MovieDetails movie;

    private double price;

    private int days;

    @Enumerated(EnumType.STRING)
    private Status status;


    @Override
    public String toString() {
        return "Rentals{" +
                "id=" + this.getId() +
                "customer=" + customer.getCustumerId() +
                ", movie=" + movie.getMovieId() +
                ", price=" + price +
                '}';

    }

}
