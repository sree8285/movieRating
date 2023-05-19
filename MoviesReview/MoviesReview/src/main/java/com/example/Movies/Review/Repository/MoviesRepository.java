package com.example.Movies.Review.Repository;

import com.example.Movies.Review.entities.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MoviesRepository extends JpaRepository<Movies,Integer> {

    @Query(value = "select * from movies where movie_name=:movie_name",nativeQuery = true)
    public Movies getMovieByName(@Param("movie_name") String movie_name);
}
