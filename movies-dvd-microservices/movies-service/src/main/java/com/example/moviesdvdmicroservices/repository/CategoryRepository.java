package com.example.moviesdvdmicroservices.repository;

import com.example.moviesdvdmicroservices.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findDistinctFirstByCategoryName(String category);
//    Category findCategoryByCategoryNameStartingWith(String category);
}
