package com.example.Movies.Review.Controller;

import com.example.Movies.Review.Dto.DTo;
import com.example.Movies.Review.Service.MovieService;
import com.example.Movies.Review.entities.Actors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
//@RequestMapping("/movies")
public class ActorsController {
    @Autowired
    private MovieService moviesRatingService;

    @PostMapping("/insert-actors-data")
    public ResponseEntity<Actors> insertMovieData(@RequestBody Actors actors) {
        try {
            log.info("insertion is started");
            return new ResponseEntity<>(moviesRatingService.insertMoviesData(actors), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error found at inserting actors data");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/actors")
    public ResponseEntity<List<Actors>> getActorsData() {
        try {
            log.info("getting actors is started");
            return new ResponseEntity<>(moviesRatingService.actorsData(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error found at geting all actors list");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/update-actor/{actorId}")
    public ResponseEntity<Actors> updateActors(@PathVariable("actorId")int actorId, @RequestBody DTo dto){
        return moviesRatingService.updateActors(actorId,dto);
    }
    @DeleteMapping("/{actorId}")
    public void delActor(@PathVariable("actorId")int actorId){
        moviesRatingService.delActors(actorId);
    }

}
