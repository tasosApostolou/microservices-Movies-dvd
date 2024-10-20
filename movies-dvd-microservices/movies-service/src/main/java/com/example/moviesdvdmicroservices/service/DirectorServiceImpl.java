package com.example.moviesdvdmicroservices.service;

import com.example.moviesdvdmicroservices.dto.DirectorDTO.DirectorInsertDTO;
import com.example.moviesdvdmicroservices.exceptions.EntityNotFoundException;
import com.example.moviesdvdmicroservices.mapper.Mapper;
import com.example.moviesdvdmicroservices.model.Director;
import com.example.moviesdvdmicroservices.repository.DirectorsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DirectorServiceImpl implements IDirectorService {
    private final DirectorsRepository directorsRepository;  //injected as autowired by annotation @RequiredArgsConstructor
    @Override
    @Transactional
    public Director insert(DirectorInsertDTO dto) throws Exception {
        Director director;
        try {
            director = directorsRepository.save(Mapper.mapToDirector(dto));
            if (director.getId() == null) {
                throw new Exception("Insert error");
            }
            log.info("insert succes for director with id" + director.getId());
            return director;
        } catch (Exception e) {
            log.error("insert error " + e.getMessage());
            throw e;
        }
    }
    @Override
    public List<Director> getDirectorsByLastname(String lastname) throws EntityNotFoundException {
        List<Director> directors = new ArrayList<>();
        try {
            directors = directorsRepository.findByLastnameStartingWith(lastname);
            if (directors.isEmpty()) throw new EntityNotFoundException(Director.class,0L);
            log.info("Directors with lastname starting with "+ lastname +" were found");
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return directors;
    }

    @Override
    public Director getDirectorById(Long id) throws EntityNotFoundException {
        Director director;
        try {
//                director = directorRepository.findDirectorById(id);
//                if(director==null)throw new EntityNotFoundException(Director.class,id);
            director = directorsRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Director.class,id));
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return director;
    }

    @Override
    public List<Director> getAllDirectors() throws Exception {
        List<Director> directors = new ArrayList<>();
        try {
            directors = directorsRepository.findAll();
            if (directors.isEmpty()) throw new EntityNotFoundException(Director.class,0L);
            log.info("Directors "+" were found");
        }catch (EntityNotFoundException e){
            log.error(e.getMessage());
            throw e;
        }
        return directors;
    }
}
