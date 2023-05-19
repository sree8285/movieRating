package com.example.Movies.Review.Service;

import com.example.Movies.Review.Dto.RatingDto;
import com.example.Movies.Review.Repository.MoviesRepository;
import com.example.Movies.Review.Repository.RatingRepository;
import com.example.Movies.Review.Repository.UsersRepository;
import com.example.Movies.Review.entities.Movies;
import com.example.Movies.Review.entities.Rating;
import com.example.Movies.Review.entities.RatingKey;
import com.example.Movies.Review.entities.Users;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private MoviesRepository moviesRepository;

    public Rating addRating(Rating rating) {
        return ratingRepository.save(rating);
    }


    public ResponseEntity<Rating> addOrUpdateRating(int userId, int movieId, RatingDto ratingDto) {
        try {
            log.info(ratingDto.toString());
            RatingKey ratingKey = new RatingKey(movieId, userId);
            Rating existingRating = ratingRepository.findById(ratingKey).orElse(null);
            if (existingRating != null) {
                existingRating.setComments(ratingDto.getComments());
                existingRating.setRating(ratingDto.getRating());
                existingRating.setRatingKey(ratingKey);
                ratingRepository.save(existingRating);
                return new ResponseEntity<>(existingRating, HttpStatus.OK);
            }
            Movies movie = moviesRepository.findById(movieId).get();
            Users user = usersRepository.findById(userId).get();
            System.out.println(user);
            Rating newRating = new Rating();
            newRating.setRating(ratingDto.getRating());
            newRating.setComments(ratingDto.getComments());
            newRating.setMovie(movie);
            newRating.setRatingKey(ratingKey);
            newRating.setUser(user);
            System.out.println("hi");
            return new ResponseEntity<Rating>(ratingRepository.save(newRating), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("no user or movie exists with this id "+userId+" "+movieId);
            System.out.println("no user exists with this id ");
            return new ResponseEntity("no user or movie exists with this id",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public ResponseEntity<Rating> addRatingToMovie(int movieId, RatingDto ratingDto) {
        try {
            log.info(ratingDto.toString());
            Movies movies = moviesRepository.findById(movieId).orElseThrow();
            Users user = usersRepository.findById(ratingDto.getUserId()).orElseGet(() -> {
                Users newUser = new Users();
                newUser.setEmail(ratingDto.getEmail());
                newUser.setPhNumber(ratingDto.getPhNumber());
                return usersRepository.save(newUser);
            });
            Rating rating = new Rating();
            rating.setComments(ratingDto.getComments());
            rating.setRating(ratingDto.getRating());
            rating.setUser(user);
            rating.setMovie(movies);
            ratingRepository.save(rating);
            return new ResponseEntity<>(rating, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error occured");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Rating> addRatingMovie(int movieId, int userId, RatingDto ratingDto) {
        try {
            Movies exists = moviesRepository.findById(movieId).orElseThrow();
            exists.setMovieId(movieId);
            Users exist = usersRepository.findById(userId).orElseThrow();
            exist.setUserId(userId);

            Rating rating = new Rating();
            rating.setRating(ratingDto.getRating());
            rating.setComments(ratingDto.getComments());
            rating.setMovie(exists);
            rating.setUser(exist);
            ratingRepository.save(rating);
            return new ResponseEntity<>(rating, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error occured" + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
