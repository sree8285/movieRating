package com.example.Movies.Review.Controller;

import com.example.Movies.Review.Dto.DTo;
import com.example.Movies.Review.Service.MovieService;
import com.example.Movies.Review.entities.Directors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DirectorsController {
    @Autowired
    private MovieService service;

    @PostMapping("/insert-directors-data")
    public ResponseEntity<Directors> insertDirectors(@RequestBody Directors directors) {
        try {
            log.info("insertion is started");
            return new ResponseEntity<>(service.insertDirectors(directors), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error occured at inserting directors");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getDirectors")
    public ResponseEntity<List<Directors>> getDirectorsData() {
        try {
            log.info("getting started");
            return new ResponseEntity<>(service.getDirectorsData(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error occured at getting directors list");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-director/{directorId}")
    public ResponseEntity<Directors> updateDirector(@PathVariable("directorId")int directorId, @RequestBody DTo dto){
        return service.updateDirectors(directorId,dto);
    }
    @DeleteMapping("/{directorId}")
    public void delDirector(@PathVariable("directorId") int directorId){
        service.delDirector(directorId);
    }
}
