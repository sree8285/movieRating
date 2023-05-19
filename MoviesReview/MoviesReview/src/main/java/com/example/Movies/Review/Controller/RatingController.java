package com.example.Movies.Review.Controller;

import com.example.Movies.Review.Dto.RatingDto;
import com.example.Movies.Review.Service.RatingService;
import com.example.Movies.Review.entities.Rating;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@Slf4j
public class RatingController {
    @Autowired
    private RatingService ratingService;

    @PostMapping("/add-rating")
    public Rating addRating(@RequestBody Rating rating) {
        return ratingService.addRating(rating);
    }

    @PutMapping("/{userId}/update-rating/{movieId}")
    public ResponseEntity<Rating> addOrUpdateRating(@PathVariable("userId") int userId, @PathVariable("movieId") int movieId, @RequestBody RatingDto ratingDto) {
        return ratingService.addOrUpdateRating(userId, movieId, ratingDto);
    }

    @PostMapping("/{movieId}/rate-movie")
    public ResponseEntity<Rating> addRatingToMovie(@PathVariable("movieId") int movieId, @RequestBody RatingDto ratingDto) {
        log.info(ratingDto.toString());
        return ratingService.addRatingToMovie(movieId, ratingDto);
    }

    @PostMapping("/{movieId}/rate-movie/{userId}")
    public ResponseEntity<Rating> addRatingToMoviee(@PathVariable("movieId") int movieId, @PathVariable("userId") int userId, @RequestBody RatingDto ratingDto) {
        return ratingService.addRatingMovie(movieId, userId, ratingDto);
    }


}
