package com.example.movieshql.repository;

import com.example.movieshql.model.Genre;
import com.example.movieshql.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Query("SELECT am.movie FROM ActorMovie am WHERE am.actor.rating > :rating")
    List<Movie> findMoviesByActorsWithHigherRatingThan(@Param("rating") Double rating);

    List<Movie> findMoviesByGenre(Genre genre);
}
