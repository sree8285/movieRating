package com.example.Movies.Review.Repository;

import com.example.Movies.Review.entities.Directors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorsRepository extends JpaRepository<Directors,Integer> {
}
