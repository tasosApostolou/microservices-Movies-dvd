package com.example.moviesdvdmicroservices.repository;

import com.example.moviesdvdmicroservices.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
    Customer findCustomerById(Long id);
    List<Customer> findByLastnameStartingWith(String lastname);

}
