package com.example.apigateway;


//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.CorsConfigurationSource;
//import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import java.util.List;

@Configuration
public class GateWayRoutesConfig {
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("movies-service", r -> r.path("/api/movie/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("moviesCircuitBreaker")
                                .setFallbackUri("forward:/fallbackRoute")))
                        .uri("lb://movies-service"))
                .route("inventory-service", r -> r.path("/api/inventory/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("inventoryCircuitBreaker")
                                .setFallbackUri("forward:/fallbackRoute")))
                        .uri("lb://inventory-service"))
                .route("order-service", r -> r.path("/api/movie/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("movieCircuitBreaker")
                                .setFallbackUri("forward:/fallbackRoute")))
                        .uri("lb://order-service"))
                .route("rentals-service", r -> r.path("/api/rental/**")
                        .filters(f -> f.circuitBreaker(c -> c.setName("rentalsCircuitBreaker")
                                .setFallbackUri("forward:/fallbackRoute")))
                        .uri("lb://rentals-service"))
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


//    @Bean
//    public CorsWebFilter corsWebFillter() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedOrigin("http://localhost:4200"); // Allow your Angular app's origin
//        corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
//        corsConfig.addAllowedHeader("*"); // Allow all headers
//        corsConfig.setAllowCredentials(true); // Allow credentials (cookies, authorization headers, etc.)
//
//        // Use the reactive UrlBasedCorsConfigurationSource
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);
//
//        return new CorsWebFilter(source);
//    }
}