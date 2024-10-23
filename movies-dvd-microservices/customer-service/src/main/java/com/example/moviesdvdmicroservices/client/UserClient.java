package com.example.moviesdvdmicroservices.client;

import com.example.moviesdvdmicroservices.dto.UserInfoResponse;
import com.example.moviesdvdmicroservices.dto.UserRegisterDTO;
import groovy.util.logging.Slf4j;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;

import java.util.Optional;

@Slf4j
    public interface UserClient {
        @PostExchange("api/user/register")
        @CircuitBreaker(name = "userRegister", fallbackMethod = "fallbackMethod")
        @Retry(name = "userRegister")
        Optional<UserInfoResponse> registerUser(@RequestParam String role, @RequestBody UserRegisterDTO credentials);
        Logger log = LoggerFactory.getLogger(UserClient.class);
        default Optional<?> fallbackMethod(String role,UserRegisterDTO dto,Throwable throwable){
            log.info("Cannot register {} for username {}, failure : {}",role,dto.getUsername(),throwable.getMessage());
            return Optional.empty();
        }
    }


