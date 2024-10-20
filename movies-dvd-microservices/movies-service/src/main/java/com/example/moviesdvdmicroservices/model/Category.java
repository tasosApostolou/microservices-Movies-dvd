package com.example.moviesdvdmicroservices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends AbstractEntity {
    @Column(unique = true)
    private String categoryName;

//    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//    @JoinTable(name = "Category_Movie",
//            joinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false),
//            inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id",nullable = false))
//    private Set<Movies> movies = new HashSet<>();

    @ManyToMany(mappedBy = "categories")
    private Set<Movies> movies = new HashSet<>();

    public Category(String categoryName) {
        this.categoryName = categoryName;
    }

    public Set<Movies> getAllMovies(){return Collections.unmodifiableSet(movies);
    }
}
