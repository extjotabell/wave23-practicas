package com.example.movieshql.repository;

import com.example.movieshql.model.Actor;
import com.example.movieshql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Long> {

    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findActorsWithFavoriteMovie();

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findActorsWithRatingHigherThan(@Param("rating") Double rating);

    List<Actor> findActorsByFavoriteMovie(Movie favoriteMovie);
}
