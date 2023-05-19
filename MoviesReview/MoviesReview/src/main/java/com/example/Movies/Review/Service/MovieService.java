package com.example.Movies.Review.Service;

import com.example.Movies.Review.Dto.DTo;
import com.example.Movies.Review.Dto.MovieDto;
import com.example.Movies.Review.Repository.ActorsRepository;
import com.example.Movies.Review.Repository.DirectorsRepository;
import com.example.Movies.Review.Repository.MoviesRepository;
import com.example.Movies.Review.Repository.ProducersRepository;
import com.example.Movies.Review.entities.Actors;
import com.example.Movies.Review.entities.Directors;
import com.example.Movies.Review.entities.Movies;
import com.example.Movies.Review.entities.Producers;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class MovieService {
    @Autowired
    private MoviesRepository repository;
    @Autowired
    private ActorsRepository actorsRepository;
    @Autowired
    private ProducersRepository producersRepository;
    @Autowired
    private DirectorsRepository directorsRepository;

    public Actors insertMoviesData(Actors actors) {
        return actorsRepository.save(actors);
    }

    public List<Actors> actorsData() {
        return actorsRepository.findAll();
    }
    public ResponseEntity<Actors> updateActors(int id, DTo dto) {
        try {
            Actors actors = actorsRepository.findById(id).orElseThrow();
            actors.setMovieHero(dto.getMovieHero());
            actors.setMovieHeroine(dto.getMovieHeroine());
            return new ResponseEntity<>(actorsRepository.save(actors), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delActors(int actorId) {
        actorsRepository.deleteById(actorId);
    }


//    ---------------------------------------------------------------

    public Producers insertProducers(Producers producers) {
        return producersRepository.save(producers);
    }

    public List<Producers> getProducers() {
        return producersRepository.findAll();
    }
    public ResponseEntity<Producers> updateProducer(int producerId, DTo dto) {
        try {
            log.info(dto.toString());
            Producers p = producersRepository.findById(producerId).orElseThrow();
            p.setProducerName(dto.getProducerName());
            return new ResponseEntity<>(producersRepository.save(p), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("error occured");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delProducer(int producerId) {
        producersRepository.deleteById(producerId);
    }

//    =================================================================

    public Directors insertDirectors(Directors directors) {
        return directorsRepository.save(directors);
    }

    public List<Directors> getDirectorsData() {
        return directorsRepository.findAll();
    }
    public ResponseEntity<Directors> updateDirectors(int directorId, DTo dto) {
        try {
            log.info(dto.toString());
            Directors d = directorsRepository.findById(directorId).orElseThrow();
            d.setDirectorName(dto.getDirectorName());
            return new ResponseEntity<>(directorsRepository.save(d), HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            log.error("error occured");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delDirector(int directorId) {
        actorsRepository.deleteById(directorId);
    }


//    +++++++++++++++++++++++++++++++++++++++++++++

    public Movies insertMovies(Movies movies) {
        return repository.save(movies);
    }

    public List<Movies> getAllMovies() {
        return repository.findAll();
    }

    public ResponseEntity<Movies> getMovieByName(String movie_name)
    {
        try {
            log.info("getting started using"+movie_name);
            return new ResponseEntity<>(repository.getMovieByName(movie_name), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            log.error("error occured");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<Movies> updateMovie(int movieId, MovieDto movieDto){
        try{
            log.info(movieDto.toString());
            Movies movies=repository.findById(movieId).orElseThrow();
            movies.setMovieName(movieDto.getMovieName());
            movies.setMusicDirector(movieDto.getMusicDirector());
            movies.setOttPlatForm(movieDto.getOttPlatForm());
            movies.setReleaseDate(movieDto.getReleaseDate());
            return new ResponseEntity<>(repository.save(movies),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            log.error("error occured"+e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public void delMovieByName(int movieId){
         repository.deleteById(movieId);
    }

}
