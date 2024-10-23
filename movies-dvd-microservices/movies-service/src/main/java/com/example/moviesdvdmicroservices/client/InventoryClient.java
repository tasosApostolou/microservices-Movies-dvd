package com.example.moviesdvdmicroservices.client;

import com.example.moviesdvdmicroservices.dto.InventoryAddResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.PostExchange;

public interface InventoryClient {
    @PostExchange("api/inventory")
    @CircuitBreaker(name = "inventory",  fallbackMethod = "fallbackMethod")
    @Retry(name = "inventory")
    InventoryAddResponse AddNewMovie(@RequestParam Long movieId, @RequestParam int quantity);
    Logger log = LoggerFactory.getLogger(InventoryClient.class);
    default InventoryAddResponse fallbackMethod(Long movieId, int quantity, Throwable throwable){
        log.info("Cannot get inventory for movieId {}, failure reason: {}",movieId,throwable.getMessage());
        return new InventoryAddResponse(movieId,quantity);
    }
}