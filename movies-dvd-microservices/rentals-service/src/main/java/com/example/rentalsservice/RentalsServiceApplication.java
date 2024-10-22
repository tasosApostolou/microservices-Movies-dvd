package com.example.rentalsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
public class RentalsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentalsServiceApplication.class, args);
    }

}
