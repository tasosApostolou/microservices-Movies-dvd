package com.example.moviesdvdmicroservices.dto.CategoryDTO;

import com.example.moviesdvdmicroservices.dto.BaseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryReadOnlyDTO extends BaseDTO {
    public String categoryName;

    public CategoryReadOnlyDTO(Long id,String categoryName) {
        this.setId(id);
        this.categoryName = categoryName;
    }
}
