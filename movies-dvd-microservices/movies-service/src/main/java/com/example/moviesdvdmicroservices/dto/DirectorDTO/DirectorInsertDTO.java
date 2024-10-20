package com.example.moviesdvdmicroservices.dto.DirectorDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class DirectorInsertDTO {
    @NotNull
    public String firstname;
    @NotNull
    public String lastname;
}
