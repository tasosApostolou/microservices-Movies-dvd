package com.example.moviesdvdmicroservices.service;

import com.example.moviesdvdmicroservices.client.InventoryClient;
import com.example.moviesdvdmicroservices.dto.ActorDTO.ActorInsertDTO;
import com.example.moviesdvdmicroservices.dto.CategoryDTO.CategoryInsertDTO;
import com.example.moviesdvdmicroservices.dto.InventoryAddResponse;
import com.example.moviesdvdmicroservices.dto.MoviesDTO.MoviesInsertDTO;
import com.example.moviesdvdmicroservices.exceptions.EntityNotFoundException;
import com.example.moviesdvdmicroservices.mapper.Mapper;
import com.example.moviesdvdmicroservices.model.Category;
import com.example.moviesdvdmicroservices.model.Director;
import com.example.moviesdvdmicroservices.model.Movies;
import com.example.moviesdvdmicroservices.repository.ActorRepository;
import com.example.moviesdvdmicroservices.repository.CategoryRepository;
import com.example.moviesdvdmicroservices.repository.DirectorsRepository;
import com.example.moviesdvdmicroservices.repository.MoviesRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MoviesServiceImpl implements IMoviesService{
    private final MoviesRepository moviesRepository;
    private final DirectorsRepository directorsRepository;
    private final CategoryRepository categoryRepository;
    private final ActorRepository actorRepository;
    private final InventoryClient inventoryClient;
    @Override
    @Transactional
    public Movies insert(MoviesInsertDTO dto) throws Exception {
        Movies movie = new Movies();
        Director director;
        try {
            director = directorsRepository.findByFirstnameAndLastname(dto.getDirector().getFirstname(),dto.getDirector().getLastname()
            ).orElseGet(() -> { // if director does not exists then create a new director in db and store it in director variable
                Director newDirector = new Director(dto.getDirector().getFirstname(),dto.getDirector().getLastname());
                return directorsRepository.save(newDirector);
            });
            movie = Mapper.mapToMovie(dto); // convert dto to model class
            InventoryAddResponse inventoryAddResponse = inventoryClient.AddNewMovie(movie.getId(), dto.getCountCopies());
            movie.setDirector(director);
            movie.setIsActive(dto.getCountCopies() > 0);
            movie = moviesRepository.save(movie);

            addCategoriesToMovie(movie,dto.getCategories());
            addActorsToMovie(movie,dto.getActors());
            if (movie.getId() == null) {
                throw new Exception("Insert error");
            }
            log.info("insert succes for movie with id" + movie.getId());
            return movie;
        } catch (Exception e) {
            log.error("insert error " + e.getMessage());
            throw e;
        }
    }

    @Override
    public List<Movies> getMoviesByTitle(String title) throws EntityNotFoundException {
        List<Movies> movies = new ArrayList<>();
        try {
            movies = moviesRepository.findMoviesByTitleStartingWith(title);
            if (movies.isEmpty()) throw new EntityNotFoundException(Movies.class,0L);
            log.info("Movies with title starting with "+ title +" were found");
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return movies;
    }

    @Override
    public Movies getMovieById(Long id) throws EntityNotFoundException {
        Movies movie;
        try {
//                movie = moviesRepository.findMovieById(id);
//                if(movie==null)throw new EntityNotFoundException(Movies.class,id);
            movie = moviesRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Movies.class,id));
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return movie;
    }

    private void addCategoriesToMovie(Movies movie, List<CategoryInsertDTO> categories) throws Exception{
        Category categoryToAdd;
        for (CategoryInsertDTO categoryInsertDTO : categories) {
            if (categoryRepository.findDistinctFirstByCategoryName(categoryInsertDTO.getCategoryName()).isEmpty()) {
                categoryRepository.save(Mapper.mapToCategory(categoryInsertDTO));
            }
            categoryToAdd = categoryRepository.findDistinctFirstByCategoryName(categoryInsertDTO.getCategoryName()).orElseThrow(() -> new Exception("Problem in insert of a category"));
            movie.addCategory(categoryToAdd);
        }
    }
    private void addActorsToMovie(Movies movie, List<ActorInsertDTO> actors){
        actors.forEach(actorDTO -> movie.addActor( // model API utility method(adding record to movie_actors, both sides)
                actorRepository.findByFirstnameAndLastname(actorDTO.getFirstname(),actorDTO.getLastname()) //find the given actor if exists to add it into movie_actors
                        .orElseGet( () -> { // if actor doesnt exists, creates new actor and add it into movie_actors
                            return actorRepository.save(Mapper.mapToActor(actorDTO)); // create new actor and add it into movie_actors
                        })
        ));
    }
    @Override
    public List<Movies> getAllMovies() throws EntityNotFoundException {
        List<Movies> movies = new ArrayList<>();
        try {
            movies = moviesRepository.findAll();
            if (movies.isEmpty()) throw new EntityNotFoundException(Movies.class,0L);
            log.info("Movies were found");
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return movies;    }
}
