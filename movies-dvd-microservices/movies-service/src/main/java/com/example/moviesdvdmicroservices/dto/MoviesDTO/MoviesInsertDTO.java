package com.example.moviesdvdmicroservices.dto.MoviesDTO;


import com.example.moviesdvdmicroservices.dto.ActorDTO.ActorInsertDTO;
import com.example.moviesdvdmicroservices.dto.CategoryDTO.CategoryInsertDTO;
import com.example.moviesdvdmicroservices.dto.DirectorDTO.DirectorInsertDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class MoviesInsertDTO{
    @NotNull
    public String title;
    @NotNull
    public int year;
    public int countCopies;
    public DirectorInsertDTO director;
    public List<CategoryInsertDTO> categories = new ArrayList<>();
    public List<ActorInsertDTO> actors = new ArrayList<>();
}
