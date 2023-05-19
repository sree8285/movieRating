package com.example.Movies.Review.Repository;

import com.example.Movies.Review.entities.Rating;
import com.example.Movies.Review.entities.RatingKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface RatingRepository extends JpaRepository<Rating, RatingKey> {
}
