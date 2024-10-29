package com.example.moviesdvdmicroservices.Config;

//import com.example.apigateway.JwtUtil;
import com.example.moviesdvdmicroservices.service.JwtService;
import lombok.RequiredArgsConstructor;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.context.ReactiveSecurityContextHolder;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter implements WebFilter {

    private final JwtService jwtUtil;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String authorizationHeader = request.getHeaders().getFirst("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            if (jwtUtil.validateToken(token)) {
                String username = jwtUtil.extractUsername(token);
                List<String> roles = List.of(jwtUtil.extractUserRole(token));
//
//                List<SimpleGrantedAuthority> authorities = roles.stream()
//                        .map(SimpleGrantedAuthority::new)
//                        .collect(Collectors.toList());
//
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                        username, null, authorities);
//
//                SecurityContext context = new SecurityContextImpl(authentication);

                // Add the authentication object to the reactive context
            }
        }

        return chain.filter(exchange);
    }
}
