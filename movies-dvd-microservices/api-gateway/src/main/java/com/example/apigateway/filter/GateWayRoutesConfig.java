package com.example.apigateway.filter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayRoutesConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
//                .route("movies-service", r -> r.path("/api/movie/**")
//                        .filters(f -> f.circuitBreaker(c -> c.setName("moviesCircuitBreaker")
//                                .setFallbackUri("forward:/fallbackRoute")))
//                        .uri("lb://movies-service"))
//                .route("inventory-service", r -> r.path("/api/inventory/**")
//                        .filters(f -> f.circuitBreaker(c -> c.setName("inventoryCircuitBreaker")
//                                .setFallbackUri("forward:/fallbackRoute")))
//                        .uri("lb://inventory-service"))
//                .route("order-service", r -> r.path("/api/movie/**")
//                        .filters(f -> f.circuitBreaker(c -> c.setName("movieCircuitBreaker")
//                                .setFallbackUri("forward:/fallbackRoute")))
//                        .uri("lb://order-service"))
//                .route("rentals-service", r -> r.path("/api/rental/**")
//                        .filters(f -> f.circuitBreaker(c -> c.setName("rentalsCircuitBreaker")
//                                .setFallbackUri("forward:/fallbackRoute")))
//                        .uri("lb://rentals-service"))
                .route("customer-service", r -> r.path("/api/customer/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("customerCircuitBreaker")
                                .setFallbackUri("forward:/fallbackRoute")))
                        .uri("lb://customer-service"))
                .route("user-service", r -> r.path("/api/user/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("userCircuitBreaker")
                                .setFallbackUri("forward:/fallbackRoute")))
                        .uri("lb://user-service"))
                .build();
    }
}
