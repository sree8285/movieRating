package com.example.Movies.Review.Controller;

import com.example.Movies.Review.Dto.MovieDto;
import com.example.Movies.Review.Service.MovieService;
import com.example.Movies.Review.entities.Movies;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MoviesController {
    @Autowired
    private MovieService service;

    @PostMapping("/insert-movies")
    public ResponseEntity<Movies> insertMovies(@RequestBody Movies movies) {
        try {
            log.info("insertion is started");
            return new ResponseEntity<>(service.insertMovies(movies), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error occured at inserting movies data");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getmovies")
    public ResponseEntity<List<Movies>> getAllMovies() {
        try {
            log.info("getting is started");
            return new ResponseEntity<>(service.getAllMovies(), HttpStatus.OK);

        } catch (Exception e) {
            log.error("error occured at getting all movies");
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-movie/{movie_name}")
    public ResponseEntity<Movies> getMovieByName(@PathVariable("movie_name") String movie_name) {
        return service.getMovieByName(movie_name);
    }

    public ResponseEntity<Movies> updateMovieData(@PathVariable("movieId")int movieId, @RequestBody MovieDto movieDto){
        return service.updateMovie(movieId, movieDto);
    }

    @DeleteMapping("/{movieId}")
    public void deleteMovieById(@PathVariable("movieId") int movieId) {
        service.delMovieByName(movieId);
    }



}
