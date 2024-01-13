package com.ejercicio.Movies.repository;

import com.ejercicio.Movies.model.Actor;
import com.ejercicio.Movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT movie FROM Movie movie JOIN movie.actors actor WHERE actor.rating > :rating")
    List<Movie> findMoviesWithActorsWithRatingGreaterThan(double rating);

    @Query("FROM Movie movie WHERE movie.genre.name = :genre")
    List<Movie> findMoviesByGenre(@Param("genre") String genre);
}
