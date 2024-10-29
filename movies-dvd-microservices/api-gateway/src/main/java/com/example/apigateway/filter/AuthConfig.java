package com.example.apigateway.filter;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;


import com.example.apigateway.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.web.cors.CorsConfiguration;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.filter.reactive.CorsWebFilter;

import java.util.List;

@Configuration
//@EnableWebSecurity
//@EnableMethodSecurity
@EnableWebFluxSecurity
@RequiredArgsConstructor
public class AuthConfig {

        private final JwtAuthenticationFilter jwtAuthenticationFilter;
        private final JwtUtil jwtUtil;
    @Bean
    public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) throws Exception {
        return http
                .csrf(ServerHttpSecurity.CsrfSpec::disable)
                .cors((cors) -> cors
                        .configurationSource(corsConfigurationSource())
                )
//                .headers(headers -> headers
//                        .frameOptions(frameOptions -> frameOptions.disable()))
                .authorizeExchange(authz -> authz
                        .pathMatchers("/api/customer/register").permitAll()
                        .pathMatchers("/api/customer/**").hasAnyAuthority("customer")
                        .pathMatchers("/api/user/token").permitAll()
                        .pathMatchers("/api/user/validate").permitAll()
                        .pathMatchers("/actuator/prometheus").permitAll()
                        .pathMatchers("/actuator/**").permitAll()      // Prometheus & Actuator endpoints
                        .pathMatchers("/zipkin/**").permitAll()        // Zipkin tracing endpoints
                        .pathMatchers("/api/v2/spans").permitAll()     // Zipkin trace collection
                        .pathMatchers("/loki/**").permitAll()          // Loki log collection endpoints
                        .pathMatchers("/tempo/**").permitAll()         // Tempo tracing endpoints
                        .pathMatchers("/grafana/**").permitAll()       // Grafana for dashboards
                        .pathMatchers("/api/datasources/**").permitAll() // Grafana data sources
                        .pathMatchers("/api/dashboards/**").permitAll()
                        .pathMatchers("/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs.yaml", "/swagger-resources/**").permitAll()
                        .anyExchange().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .addFilterAt( new JwtAuthenticationFilter(jwtUtil), SecurityWebFiltersOrder.AUTHENTICATION) // Use the injected filter

                .build();
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(requestFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
    }
//
//    @Bean
//    public CorsWebFilter corsWebFilter() {
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedOrigin("http://localhost:4200"); // Allow your Angular app's origin
//        corsConfig.addAllowedMethod("*"); // Allow all HTTP methods
//        corsConfig.addAllowedHeader("*"); // Allow all headers
//        corsConfig.setAllowCredentials(true); // Allow credentials like cookies or auth headers
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", corsConfig);
//
//        return new CorsWebFilter(source);
//    }


//    @Bean
//    public JwtAuthenticationFilter jwtAuthenticationFilter(JwtUtil jwtUtil) {
//        return new JwtAuthenticationFilter(jwtUtil); // Pass JwtUtil to the filter
//    }

@Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration corsConfig = new CorsConfiguration();
    corsConfig.addAllowedOrigin("http://localhost:4200");
    corsConfig.addAllowedMethod("*");
    corsConfig.addAllowedHeader("*");
    corsConfig.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfig);
    return source;
}


    @Bean
    public CorsWebFilter corsWebFilter() {
        return new CorsWebFilter(corsConfigurationSource());
    }
}
















//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class AuthConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new CustomUserDetailsService();
//    }
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http.csrf().disable()
////                .authorizeHttpRequests()
////                .requestMatchers("/auth/register", "/auth/token", "/auth/validate").permitAll()
////                .and()
////                .build();
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/auth/register", "/auth/token", "/auth/validate").permitAll()
//                        .anyRequest().authenticated())
//                .build();
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//}






//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class AuthConfig {
//
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new CustomUserDetailsService();
//    }
//
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
////        return http.csrf().disable()
////                .authorizeHttpRequests()
////                .requestMatchers("/auth/register", "/auth/token", "/auth/validate").permitAll()
////                .and()
////                .build();
//        return http
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/auth/register", "/auth/token", "/auth/validate").permitAll()
//                        .anyRequest().authenticated())
//                .build();
//
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationProvider authenticationProvider(){
//        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService());
//        authenticationProvider.setPasswordEncoder(passwordEncoder());
//        return authenticationProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//}
