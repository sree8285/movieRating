package com.example.Movies.Review.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Movies
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;
    private String movieName;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date releaseDate;
    private String musicDirector;
    private String ottPlatForm;
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name="movie_id",referencedColumnName = "movieId")
    @JoinTable(name = "movie_actor", joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "actor_id",referencedColumnName = "actorId"))
    private Set<Actors> actors=new HashSet<>();
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movie_director", joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "director_id",referencedColumnName = "directorId"))
    @JoinColumn(name="movie_id",referencedColumnName = "movieId")
    private Set<Directors> directors=new HashSet<>();
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "movie_producer", joinColumns = @JoinColumn(name = "movie_id",referencedColumnName = "movieId"),
            inverseJoinColumns = @JoinColumn(name = "producer_id",referencedColumnName = "producerId"))
    @JoinColumn(name="movie_id",referencedColumnName = "movieId")
    private Set<Producers> producers=new HashSet<>();

//    @OneToMany(cascade = {CascadeType.ALL})
//    @JoinColumn(name="movie_id",referencedColumnName = "movieId")
//    private Set<Rating> ratings = new HashSet<>();

}
