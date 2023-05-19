package com.example.Movies.Review.Dto;

import com.example.Movies.Review.entities.Movies;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class RatingDto {


    private int userId;
    private double rating;

    private String comments;

    private String email;

    private long phNumber;

}
