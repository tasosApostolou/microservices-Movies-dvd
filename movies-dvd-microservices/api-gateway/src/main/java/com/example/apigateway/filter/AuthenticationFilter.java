package com.example.apigateway.filter;

import com.example.apigateway.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;

    //    @Autowired
    @Autowired
    private JwtUtil jwtUtil;

    public AuthenticationFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
//        return ((exchange, chain) -> {
//            ServerHttpRequest request = null;
//            if (validator.isSecured.test(exchange.getRequest())) {
//                //header contains token or not
//                if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
//                    throw new RuntimeException("missing authorization header");
//                }
//
//                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
//                if (authHeader != null && authHeader.startsWith("Bearer ")) {
//                    authHeader = authHeader.substring(7);
//                }
//                try {
//                    jwtUtil.validateToken(authHeader);
//
//                    request = exchange.getRequest()
//                            .mutate()
//
////                            .header("loggedInUser", jwtUtil.extractUsername(authHeader))
//                            .header("loggedInUser",authHeader)
//                            .build();
//                } catch (Exception e) {
//                    System.out.println("invalid access...!");
//                    throw new RuntimeException("un authorized access to application");
//                }
//            }
//            return chain.filter(exchange.mutate().request(request).build());
//        });
//    }
//
//    public static class Config {
//
//    }
//}






        return (exchange, chain) -> {
                String token = extractJwtToken(exchange.getRequest().getHeaders());
                if (token != null) {
                    exchange.getRequest().mutate().header("Authorization", "Bearer " + token).build();
                }
                return chain.filter(exchange);
            };
        }

        private String extractJwtToken(HttpHeaders headers) {
            String authorizationHeader = headers.getFirst(HttpHeaders.AUTHORIZATION);
            if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
                return authorizationHeader.substring(7);
            }
            return null;
        }
    public static class Config {

    }
}