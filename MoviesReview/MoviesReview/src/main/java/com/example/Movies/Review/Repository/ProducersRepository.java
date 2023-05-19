package com.example.Movies.Review.Repository;

import com.example.Movies.Review.entities.Producers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProducersRepository extends JpaRepository<Producers,Integer> {
}
