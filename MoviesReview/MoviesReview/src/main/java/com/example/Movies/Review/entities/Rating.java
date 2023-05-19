package com.example.Movies.Review.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@Data
@Setter
@AllArgsConstructor
@Table
public class Rating {
    @EmbeddedId
    private RatingKey ratingKey;
    private double rating;
    private String comments;
    @MapsId("userId")
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private Users user;
    @MapsId("movieId")
    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Movies.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id", referencedColumnName = "movieId")
    private Movies movie;
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
}
