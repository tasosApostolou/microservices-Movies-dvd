package com.example.moviesdvdmicroservices.service;



import com.example.moviesdvdmicroservices.Exception.EntityAlreadyExistsException;
import com.example.moviesdvdmicroservices.Exception.EntityNotFoundException;
import com.example.moviesdvdmicroservices.dto.CustomerRegisterDTO;
import com.example.moviesdvdmicroservices.dto.CustomerUpdateDTO;
import com.example.moviesdvdmicroservices.model.Customer;

import java.util.List;

public interface ICustomerService {
    Customer registerCustomer(CustomerRegisterDTO dto) throws EntityAlreadyExistsException;
//    List<Customer> getCustomersByLastname(String lastname) throws EntityNotFoundException;
    Customer getCustomerById(Long id) throws EntityNotFoundException;
//    Customer updateCustomer(CustomerUpdateDTO customerDTO) throws EntityNotFoundException;
//    Customer deleteCustomer(Long id) throws EntityNotFoundException;
}
