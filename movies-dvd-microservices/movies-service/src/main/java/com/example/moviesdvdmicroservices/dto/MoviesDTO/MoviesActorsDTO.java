package com.example.moviesdvdmicroservices.dto.MoviesDTO;

import com.example.moviesdvdmicroservices.dto.ActorDTO.ActorReadOnlyDTO;
import com.example.moviesdvdmicroservices.dto.BaseDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class MoviesActorsDTO extends BaseDTO {
    public String title;
    public int year;
    public int countCopies;
    public List<ActorReadOnlyDTO> actors = new ArrayList<>();

    public MoviesActorsDTO(String title, int year, int countCopies) {
        this.title = title;
        this.year = year;
        this.countCopies = countCopies;
    }

    public MoviesActorsDTO(String title, int year, int countCopies, List<ActorReadOnlyDTO> actors) {
        this.title = title;
        this.year = year;
        this.countCopies = countCopies;
        this.actors = actors;
    }
}
