package com.meli.movies.repository;

import com.meli.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {
    @Query("FROM Movie m JOIN m.actors a WHERE a.rating > :rating")
    List<Movie> findByActorRatingGreaterThan(@Param("rating") BigDecimal rating);

    @Query("FROM Movie m JOIN m.genre g WHERE g.name = :genre")
    List<Movie> findByGenre(@Param("genre") String genre);
}
