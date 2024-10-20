package com.example.moviesdvdmicroservices.dto.MoviesDTO;

import com.example.moviesdvdmicroservices.dto.ActorDTO.ActorReadOnlyDTO;
import com.example.moviesdvdmicroservices.dto.BaseDTO;
import com.example.moviesdvdmicroservices.dto.CategoryDTO.CategoryReadOnlyDTO;
import com.example.moviesdvdmicroservices.dto.DirectorDTO.DirectorReadOnlyDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MoviesReadOnlyDTO extends BaseDTO {
    public String title;
    public int year;
    public int countCopies;
    public DirectorReadOnlyDTO director;
    public List<ActorReadOnlyDTO> actors =new ArrayList<>();
    public List<CategoryReadOnlyDTO> categories = new ArrayList<>();

    public MoviesReadOnlyDTO(Long id,String title, int year, int countCopies, DirectorReadOnlyDTO director) {
        this.setId(id);
        this.title = title;
        this.year = year;
        this.countCopies = countCopies;
        this.director = director;
    }



}
