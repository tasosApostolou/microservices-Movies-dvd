package com.example.moviesdvdmicroservices.mapper;

import com.example.moviesdvdmicroservices.dto.ActorDTO.ActorInsertDTO;
import com.example.moviesdvdmicroservices.dto.ActorDTO.ActorReadOnlyDTO;
import com.example.moviesdvdmicroservices.dto.CategoryDTO.CategoryInsertDTO;
import com.example.moviesdvdmicroservices.dto.CategoryDTO.CategoryReadOnlyDTO;
import com.example.moviesdvdmicroservices.dto.DirectorDTO.DirectorInsertDTO;
import com.example.moviesdvdmicroservices.dto.DirectorDTO.DirectorReadOnlyDTO;
import com.example.moviesdvdmicroservices.dto.MoviesDTO.MoviesInsertDTO;
import com.example.moviesdvdmicroservices.dto.MoviesDTO.MoviesReadOnlyDTO;
import com.example.moviesdvdmicroservices.model.Actor;
import com.example.moviesdvdmicroservices.model.Category;
import com.example.moviesdvdmicroservices.model.Director;
import com.example.moviesdvdmicroservices.model.Movies;

public class Mapper {
    public static Actor mapToActor(ActorInsertDTO dto) {
        return new Actor(dto.getFirstname(), dto.getLastname());
    }

    public static Director mapToDirector(DirectorInsertDTO dto) {
        return new Director(dto.getFirstname(), dto.getLastname());
    }

    public static Movies mapToMovie(MoviesInsertDTO dto) {
        return new Movies(dto.getTitle(), dto.getYear(), dto.getCountCopies(), new Director(dto.getDirector().getFirstname(), dto.getDirector().getLastname()));
    }

    public static Category mapToCategory(CategoryInsertDTO dto) {
        return new Category(dto.getCategoryName());
    }

    public static ActorReadOnlyDTO mapToReadOnlyDTO(Actor actor) {
        ActorReadOnlyDTO actorDTO = new ActorReadOnlyDTO(actor.getId(), actor.getFirstname(), actor.getLastname());
        return actorDTO;
    }

    public static DirectorReadOnlyDTO mapToReadOnlyDTO(Director director) {
        DirectorReadOnlyDTO directorDTO = new DirectorReadOnlyDTO(director.getId(), director.getFirstname(), director.getLastname());
        return directorDTO;
    }

    public static CategoryReadOnlyDTO mapToReadOnlyDTO(Category category) {
        CategoryReadOnlyDTO categoryDTO = new CategoryReadOnlyDTO(category.getId(), category.getCategoryName());
        return categoryDTO;
    }

    public static MoviesReadOnlyDTO mapToReadOnlyDTO(Movies movie) {
        MoviesReadOnlyDTO movieDTO = new MoviesReadOnlyDTO(movie.getId(), movie.getTitle(), movie.getYear(), movie.getCountCopies(), mapToReadOnlyDTO(movie.getDirector()) );

//        movieDTO.setActors(movie.getAllActors().stream().map(Mapper::mapToReadOnlyDTO).collect(Collectors.toList()));
        movie.getAllActors().forEach(actor -> movieDTO.getActors().add(mapToReadOnlyDTO(actor)));
        movie.getAllCategories().forEach(category -> movieDTO.getCategories().add(mapToReadOnlyDTO(category)));
        return movieDTO;
    }

//    public static RatingsReadOnlyDTO mapToReadOnlyDTO(Ratings rating) {
//        RatingsReadOnlyDTO ratingDTO = new RatingsReadOnlyDTO(mapToReadOnlyDTO(rating.getMovie()), mapToReadOnlyDTO(rating.getCustomer()), rating.getRating());
//        return ratingDTO;
//    }

}