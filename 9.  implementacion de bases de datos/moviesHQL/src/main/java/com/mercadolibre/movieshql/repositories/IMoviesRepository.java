package com.mercadolibre.movieshql.repositories;

import com.mercadolibre.movieshql.model.entities.Genres;
import com.mercadolibre.movieshql.model.entities.Movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IMoviesRepository extends JpaRepository<Movies, Long> {

    /**
     * List all movies whose actors have a rating higher than the received as parameter.
     */
    @Query("SELECT movies FROM Movies movies JOIN ActorMovies actor_movie ON movies.id = actor_movie.movies.id " +
            "JOIN Actors actors ON actors.id = actor_movie.actors.id WHERE actors.rating > :rating")
    List<Movies> findMoviesByActorRating(Double rating);

    /**
     * List all movies that have the genre received as parameter.
     * Genres can be: Comedia, Drama, Ciencia Ficcion, Suspenso
     */
    @Query("SELECT movies FROM Movies movies WHERE movies.genres = :genres")
    List<Movies> findMoviesByGenre(Genres genres);
}
