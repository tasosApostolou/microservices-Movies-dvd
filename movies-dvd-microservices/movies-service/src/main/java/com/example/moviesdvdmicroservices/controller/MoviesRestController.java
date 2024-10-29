package com.example.moviesdvdmicroservices.controller;


import com.example.moviesdvdmicroservices.dto.MoviesDTO.MoviesInsertDTO;
import com.example.moviesdvdmicroservices.dto.MoviesDTO.MoviesReadOnlyDTO;
import com.example.moviesdvdmicroservices.exceptions.EntityNotFoundException;
import com.example.moviesdvdmicroservices.mapper.Mapper;
import com.example.moviesdvdmicroservices.model.Movies;
import com.example.moviesdvdmicroservices.service.IMoviesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/movie")
public class MoviesRestController {

    private final IMoviesService moviesService;
//    private final MoviesInsertValidator moviesInsertValidator;
    private final JwtUtil jwtUtil;
    @Operation(summary = "Add a Movie")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Movie added",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MoviesReadOnlyDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid input was supplied",
                    content = @Content),
            @ApiResponse(responseCode = "503", description = "Service Unavailable",
                    content = @Content)})
    @PostMapping("/add")
    public ResponseEntity<MoviesReadOnlyDTO> addMovie(@Valid @RequestBody MoviesInsertDTO dto,@RequestHeader("Authorization") String token, BindingResult bindingResult) {
        String actualToken = token.startsWith("Bearer ") ? token.substring(7) : token;

        String username = jwtUtil.extractUsername(actualToken);

        System.out.println("====================================================================================="+username);
//        moviesInsertValidator.validate(dto, bindingResult);
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            Movies movie = moviesService.insert(dto);
            MoviesReadOnlyDTO moviesReadOnlyDTO = Mapper.mapToReadOnlyDTO(movie);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(moviesReadOnlyDTO.getId())
                    .toUri();
            return ResponseEntity.created(location).body(moviesReadOnlyDTO);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }

    @Operation(summary = "Get Movies by their title starting with initials")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movies Found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MoviesReadOnlyDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid title supplied",
                    content = @Content)})
    @GetMapping("/title/{title}")
    public ResponseEntity<List<MoviesReadOnlyDTO>> getMoviesByTitle (@PathVariable("title") String title){
        List<Movies> movies;
        List<MoviesReadOnlyDTO> readOnlyDTOs = new ArrayList<>();
        try {
            movies = moviesService.getMoviesByTitle(title);
            movies.forEach(movie -> readOnlyDTOs.add(Mapper.mapToReadOnlyDTO(movie)));
            return new ResponseEntity<>(readOnlyDTOs, HttpStatus.OK);

        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @Operation(summary = "Get a Movie by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movie Found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MoviesReadOnlyDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Movie not found",
                    content = @Content)})
    @GetMapping("/{movieId}")
    public ResponseEntity<MoviesReadOnlyDTO> getMovie(@PathVariable("movieId") Long id){
        Movies movie;
        try {
            movie = moviesService.getMovieById(id);
            MoviesReadOnlyDTO dto = Mapper.mapToReadOnlyDTO(movie);
            return ResponseEntity.ok(dto);
        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @Operation(summary = "Get All Movies")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Movies Found",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = MoviesReadOnlyDTO.class))}),
            @ApiResponse(responseCode = "400", description = "Invalid title supplied",
                    content = @Content)})
    @GetMapping("/get")
    public ResponseEntity<List<MoviesReadOnlyDTO>> getMovies (){
        List<Movies> movies;
        List<MoviesReadOnlyDTO> readOnlyDTOs = new ArrayList<>();
        try {
            movies = moviesService.getAllMovies();
            movies.forEach(movie -> readOnlyDTOs.add(Mapper.mapToReadOnlyDTO(movie)));
            return new ResponseEntity<>(readOnlyDTOs, HttpStatus.OK);

        }catch (EntityNotFoundException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
