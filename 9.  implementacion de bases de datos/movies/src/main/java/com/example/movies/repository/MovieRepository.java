package com.example.movies.repository;

import com.example.movies.model.Actor;
import com.example.movies.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {
    @Query("select a from Actor a where a.favoriteMovie is not null")
    List<Actor> findActorsByFavoriteMovieNotNull();

    @Query("select a from Actor a where a.rating >=:rating")
    List<Actor> findActorsWithRatingHigerThan(@Param("rating") double rating);
}
