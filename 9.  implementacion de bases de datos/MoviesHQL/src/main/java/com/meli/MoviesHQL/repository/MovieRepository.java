package com.meli.MoviesHQL.repository;

import com.meli.MoviesHQL.model.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends CrudRepository<Movie, Long> {

    @Query(
        "SELECT m FROM Movie m " +
        "JOIN ActorMovie am ON m.id = am.movie.id " +
        "JOIN Actor a ON a.id = am.actor.id " +
        "WHERE a.rating > ?1"
    )
    List<Movie> findByActorsRatingGreaterThan(Double rating);

    @Query(
        "SELECT m FROM Movie m " +
        "JOIN Genre g ON m.genre.id = g.id " +
        "WHERE g.id = ?1"
    )
    List<Movie> findByGenre(Long genreId);

}