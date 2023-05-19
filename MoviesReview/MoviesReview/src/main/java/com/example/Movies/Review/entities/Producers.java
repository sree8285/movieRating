package com.example.Movies.Review.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Producers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int producerId;
    private String producerName;

//    @ManyToMany(mappedBy = "producers")
//    private Set<Movies> movies = new HashSet<>();
}
