package com.example.moviesdvdmicroservices.dto.ActorDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActorInsertDTO {
    @NotNull
    private String firstname;
    @NotNull
    private String lastname;
}
