package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.InventoryMovie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryMovie, Long>
{
    Optional<InventoryMovie> findByMovieId(Long movieId);
    InventoryMovie findInventoryMovieByMovieId(Long movieId);
}
