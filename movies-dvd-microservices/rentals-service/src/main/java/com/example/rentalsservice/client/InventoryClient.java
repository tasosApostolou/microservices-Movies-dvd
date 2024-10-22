package com.example.rentalsservice.client;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;


public interface InventoryClient {
    @GetExchange("api/inventory")
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