package com.example.Movies.Review.Repository;

import com.example.Movies.Review.entities.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorsRepository extends JpaRepository<Actors,Integer> {
}
