package com.example.Movies.Review.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int actorId;
    private String movieHero;
    private String movieHeroine;

//    @ManyToMany
//    @JoinColumn(name="movie_id",referencedColumnName = "movieId",insertable = false,updatable = false)
//    private Set<Movies> movies = new HashSet<>();

}
