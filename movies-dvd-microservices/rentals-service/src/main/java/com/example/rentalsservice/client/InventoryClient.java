package com.example.rentalsservice.client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;


public interface InventoryClient {
    @PostExchange("api/inventory")
//    @CircuitBreaker(name = "inventory", fallbackMethod = "fallbackMethod")
//    @Retry(name = "inventory")
////    @TimeLimiter()
    boolean rentalRequest(@RequestParam Long movieId);
    Logger log = LoggerFactory.getLogger(InventoryClient.class);
    default boolean fallbackMethod(Long movieId,Throwable throwable){
        log.info("Cannot get inventory for movieId {}, failure reason: {}",movieId,throwable.getMessage());
        return false;
    }
}