package com.example.moviesdvdmicroservices.RestController;


import com.example.moviesdvdmicroservices.Exceptions.UserNotFoundException;
import com.example.moviesdvdmicroservices.JWT.AuthendicationResponseDTO;
import com.example.moviesdvdmicroservices.JWT.JwtService;
import com.example.moviesdvdmicroservices.UserDTO.*;
import com.example.moviesdvdmicroservices.Validator.UserInsertValidator;
import com.example.moviesdvdmicroservices.Validator.UserUpdateValidator;
import com.example.moviesdvdmicroservices.config.UserDetailsServiceImpl;
import com.example.moviesdvdmicroservices.model.User;
import com.example.moviesdvdmicroservices.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.Objects;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserRestController {

    private final IUserService userService;
    private final UserInsertValidator insertValidator;
    private final UserUpdateValidator updateValidator;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;

    @Operation(summary = "Get a User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserReadOnlyDTO.class))}),
            @ApiResponse(responseCode = "400", description = "User not found",
                    content = @Content)})
    @GetMapping("/{userID}")
    public ResponseEntity<UserReadOnlyDTO> getUser(@PathVariable("userID") Long id) {
        User user;

        try {
            user = userService.getUserById(id);
            UserReadOnlyDTO dto = new UserReadOnlyDTO(user.getId(), user.getUsername(),user.getEmail(),String.valueOf(user.getRole()));
            return ResponseEntity.ok(dto);

        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Add a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserReadOnlyDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input was supplied",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "Service Unavailable",
                    content = @Content)})
    @PostMapping("/register")
    public ResponseEntity<UserReadOnlyDTO> registerUser(@RequestParam String role, @Valid @RequestBody @Schema(implementation = Credentials.class) Credentials credentials, BindingResult bindingResult) {
        insertValidator.validate(credentials, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        try {
            User user = userService.insertUser(role,credentials);
            UserReadOnlyDTO userReadOnlyDTO = new UserReadOnlyDTO(user.getId(), user.getUsername(),user.getEmail(),String.valueOf(user.getRole()));
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(userReadOnlyDTO.getId())
                    .toUri();
            return ResponseEntity.created(location).body(userReadOnlyDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @Operation(summary = "Update a user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserReadOnlyDTO.class)) }),
            @ApiResponse(responseCode = "401", description = "Unauthorized user",
                    content = @Content),
            @ApiResponse(responseCode = "400", description = "Invalid input was supplied",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content) })
    @PutMapping("/update/{id}")
    public ResponseEntity<UserReadOnlyDTO> updateUser(@PathVariable("id") Long id, @Valid @RequestBody @Schema(implementation = UserUpdateDTO.class) UserUpdateDTO dto, BindingResult bindingResult) {
        if (!Objects.equals(id, dto.getId())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        updateValidator.validate(dto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {

            User user = userService.updateUser(dto);
            UserReadOnlyDTO readOnlyDTO = new UserReadOnlyDTO(user.getId(), user.getUsername(), user.getPassword(), String.valueOf(user.getRole()));
            return new ResponseEntity<>(readOnlyDTO,HttpStatus.OK);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Delete a User by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User Deleted",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserReadOnlyDTO.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content)})
    @DeleteMapping("/{id}")
    public ResponseEntity<UserReadOnlyDTO> deleteUser(@PathVariable("id") Long id){
        try {
            User user = userService.deleteUser(id);
            UserReadOnlyDTO readOnlyDTO = new UserReadOnlyDTO(user.getId(), user.getUsername(),user.getPassword(),String.valueOf(user.getRole()));
            return new ResponseEntity<>(readOnlyDTO,HttpStatus.OK);
        }catch (UserNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/token")
    public AuthendicationResponseDTO login(@RequestBody AuthRequest authRequest,HttpServletResponse response) throws BadCredentialsException, DisabledException, UsernameNotFoundException, IOException {
//        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
//        if (authenticate.isAuthenticated()) {
//            String token =  jwtService.generateToken(authRequest.getUsername());
//            return new AuthendicationResponseDTO(token);
////            final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
////
////            return jwtService.generateToken(userDetails.getUsername());
//        } else {
//            throw new RuntimeException("invalid access");
//        }


        User user;
//        LoginResponseTokenDTO responseDTO;
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            user = userService.getUserByUsername(authRequest.getUsername());
//            responseDTO = Mapper.mapToLoginResponseDTO(user);
        } catch (BadCredentialsException | UserNotFoundException e) {
            throw new BadCredentialsException("Incorrect username or password!");
        } catch (DisabledException disabledException) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "User is not activated");
            return null;
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());

        final String jwt = jwtService.generateToken(userDetails.getUsername(),user.getId(), String.valueOf(user.getRole()).toLowerCase());

        return new AuthendicationResponseDTO(jwt);
    }



    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        jwtService.validateToken(token);
        return "Token is valid";
    }

}




