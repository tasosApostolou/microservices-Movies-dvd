package com.example.moviesdvdmicroservices.service;

import com.example.moviesdvdmicroservices.dto.CategoryDTO.CategoryInsertDTO;
import com.example.moviesdvdmicroservices.exceptions.EntityNotFoundException;
import com.example.moviesdvdmicroservices.model.Category;

public interface ICategoryService {
    Category insert(CategoryInsertDTO dto) throws Exception;
    Category getCategoryByCategoryName(String categoryName) throws EntityNotFoundException;
    Category getCategoryById(Long id) throws EntityNotFoundException;
}
