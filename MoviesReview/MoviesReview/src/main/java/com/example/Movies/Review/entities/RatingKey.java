package com.example.Movies.Review.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RatingKey implements Serializable {
    @Column(name = "movie_id")
    private int movieId;
    @Column(name = "user_id")
    private int userId;

}
