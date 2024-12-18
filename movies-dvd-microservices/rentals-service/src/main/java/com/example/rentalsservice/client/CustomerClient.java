package com.example.rentalsservice.client;

import com.example.rentalsservice.dto.CustomerResponseDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;

public interface CustomerClient {
    @GetExchange("api/customer/{customerID}")
    @CircuitBreaker(name = "getCustomer", fallbackMethod = "fallabackMethod")
    @Retry(name = "getCustomer")
    CustomerResponseDTO getCustomer(@PathVariable Long customerID);
    Logger log = LoggerFactory.getLogger(InventoryClient.class);
    default CustomerResponseDTO fallabackMethod(Long customerID,Throwable throwable){
        log.info("Cannot get customer with id {}, failure reason: {}",customerID,throwable.getMessage());
        return new CustomerResponseDTO();
    }
}