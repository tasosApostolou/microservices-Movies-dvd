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

//@IdClass(CustomerMovieID.class)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rentals extends AbstractEntity implements Serializable {

//    private Long customerId;
//    private Long movieId;
//    @Id
//    @ManyToOne()
//    @JoinColumn(name = "customer_id")
//    private CustomerDetails customer;
//
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    private MovieDetails movie;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long customerId;
    private Long movieId;

    private int days;
    private double price;

    @Enumerated(EnumType.STRING)
    private Status status;

    public Rentals(Object o, Long customerId, Long movieId, int days, double v) {
    }


//    @Override
//    public String toString() {
//        return "Rentals{" +
//                "customer=" + customer.getCustumerId() +
//                ", movie=" + movie.getMovieId() +
//                ", price=" + price +
//                '}';
//
//    }

    @Override
    public String toString() {
        return "Rentals{" +
                "customer=" + getCustomerId() +
                ", movie=" + getMovieId() +
                ", price=" + price +
                '}';

    }


}
