package com.meli.MoviesHQL.repository;

import com.meli.MoviesHQL.model.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends CrudRepository<Actor, Long> {

    @Query(
        "SELECT a FROM Actor a " +
        "WHERE a.favoriteMovie IS NOT NULL"
    )
    List<Actor> findByFavoriteMovieIsNotNull();

    @Query(
        "SELECT a FROM Actor a " +
        "WHERE a.rating >= ?1 " +
        "ORDER BY a.rating DESC"
    )
    List<Actor> findByRatingIsGreaterThanEqual(Double rating);

    @Query(
        "SELECT a FROM Actor a " +
        "JOIN ActorMovie am ON a.id = am.actor.id " +
        "WHERE am.movie.id = ?1"
    )
    List<Actor> findByMovie(Long movieId);

}