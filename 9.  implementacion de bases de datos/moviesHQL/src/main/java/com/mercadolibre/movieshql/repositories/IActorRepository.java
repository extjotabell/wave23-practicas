package com.mercadolibre.movieshql.repositories;

import com.mercadolibre.movieshql.model.entities.Actors;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface IActorRepository extends JpaRepository<Actors, Long> {

    /**
     * Repository to list all actors with at least one favorite movie.
     */
    @Query("SELECT actors FROM Actors actors WHERE actors.favoriteMovies IS NOT NULL")
    List<Actors> findActorsWithOneFavoriteMovie();

    /**
     * Repository to list all actors with a rating higher than the value received as parameter.
     */
    @Query("SELECT actors FROM Actors actors WHERE actors.rating > :rating")
    List<Actors> findActorsWithRatingHigherThan(BigDecimal rating);

    /**
     * Repository to list all actors that worked in a movie received as parameter.
     */
    @Query("SELECT actors FROM Actors actors JOIN ActorMovies actor_movie ON actors.id = actor_movie.actors.id " +
            "JOIN Movies movies ON movies.id = actor_movie.movies.id WHERE movies.title = :movieTitle")
    List<Actors> findActorsByMovie(String movieTitle);
}
