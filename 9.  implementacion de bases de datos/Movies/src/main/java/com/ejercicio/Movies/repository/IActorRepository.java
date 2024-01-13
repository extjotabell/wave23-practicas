package com.ejercicio.Movies.repository;

import com.ejercicio.Movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {
    @Query("FROM Actor actor WHERE actor.favoriteMovie IS NOT NULL")
    List<Actor> findActorsWithFavoriteMovie();

    @Query("FROM Actor actor WHERE actor.rating > ?1")
    List<Actor> findActorsWithRatingGreaterThan(double rating);

    @Query("SELECT actor FROM Actor actor JOIN actor.movies movie WHERE movie.title = :movie")
    List<Actor> findActorsByMovie(String movie);
}
