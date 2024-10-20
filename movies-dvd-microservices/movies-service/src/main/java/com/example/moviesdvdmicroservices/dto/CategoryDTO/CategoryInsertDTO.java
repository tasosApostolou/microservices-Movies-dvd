package com.example.moviesdvdmicroservices.dto.CategoryDTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryInsertDTO{
    @NotNull
    public String categoryName;

}
