//package com.example.apigateway.filter;
//
//import com.example.apigateway.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//
//@Component
//public class AuthEmployeeFilter extends AbstractGatewayFilterFactory<AuthEmployeeFilter.Config> {
//
//    @Autowired
//    private RouteValidator validator;
//
//    //    @Autowired
//    @Autowired
//    private JwtUtil jwtUtil;
//
//    public AuthEmployeeFilter() {
//        super(Config.class);
//    }
//
//    @Override
//    public GatewayFilter apply(Config config) {
//        return (exchange, chain) -> {
//            String token = extractJwtToken(exchange.getRequest().getHeaders());
//            // If the role is not "customer", stop the request with a 403 response
//            if (token == null || !hasCustomerRole(token)) {
//                // Return a 403 Forbidden status if role check fails
//                exchange.getResponse().setStatusCode(HttpStatus.FORBIDDEN);
//                return exchange.getResponse().setComplete();
//            }
//            exchange.getRequest().mutate()
//                    .header("Authorization", "Bearer " + token) // You can choose what to put here
//                    .build();
//            return chain.filter(exchange);
//        };
//    }
//    private String extractJwtToken(HttpHeaders headers) {
//        String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            return authorizationHeader.substring(7);
//        }
//        return null;
//    }
//
//    private boolean hasCustomerRole(String token){
//        String role  = jwtUtil.extractUserRole(token);
//        return role.equals("employee");
//    }
//    public static class Config {
//
//    }
//
//}