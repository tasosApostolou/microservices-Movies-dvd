//package com.example.apigateway;
//
//import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
//import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.servlet.function.RequestPredicates;
//import org.springframework.web.servlet.function.RouterFunction;
//import org.springframework.web.servlet.function.ServerResponse;
//
//import java.net.URI;
//
//import static org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route;
//
//@Configuration
//public class Routes {
//    @Bean
//    public RouterFunction<ServerResponse> moviesServiceRoute(){
//        return route("movies-service")
//                .route(RequestPredicates.path("/api/movies"), HandlerFunctions.http("http://localhost:8083"))
//                .filter(CircuitBreakerFilterFunctions.circuitBreaker("productServiceCircuitBreaker", URI.create("forward:/fallbackRoute")))
//                .build();
//    }
//    @Bean
//    public RouterFunction<ServerResponse> customerSericeRoute(){
//        return route("customer-service")
//                .route(RequestPredicates.path("/api/customer/register"), HandlerFunctions.http("http://localhost:8082"))
//                .filter(CircuitBreakerFilterFunctions.circuitBreaker("productServiceCircuitBreaker", URI.create("forward:/fallbackRoute")))
//                .build();
//    }
//    @Bean
//    public RouterFunction<ServerResponse> userSericeRoute(){
//        return route("user-service")
//                .route(RequestPredicates.path("/api/user"), HandlerFunctions.http("http://localhost:8081"))
//                .filter(CircuitBreakerFilterFunctions.circuitBreaker("orderServiceCircuitBreaker", URI.create("forward:/fallbackRoute")))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> inventorySericeRoute(){
//        return route("inventory-service")
//                .route(RequestPredicates.path("/api/inventory"), HandlerFunctions.http("http://localhost:8083"))
//                .filter(CircuitBreakerFilterFunctions.circuitBreaker("inventoryServiceCircuitBreaker", URI.create("forward:/fallbackRoute")))
//                .build();
//    }
//
//    @Bean
//    public RouterFunction<ServerResponse> fallbackRoute(){
//        return route("fallbackRoute")
//                .GET("/fallbackRoute", request -> ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE).body("Service temporary unavailable"))
//                .filter(CircuitBreakerFilterFunctions.circuitBreaker("productServiceCircuitBreaker", URI.create("forward:/fallbackRoute")))
//                .build();
//    }
//
//}
