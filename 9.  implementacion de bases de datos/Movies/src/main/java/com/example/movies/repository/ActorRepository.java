package com.example.movies.repository;

import com.example.movies.dto.ActorDTO;
import com.example.movies.dto.ActorSimpleDTO;
import com.example.movies.models.Actor;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

  @Query("select actor from Actor actor where actor.favoriteMovie is not null")
  List<Actor> findAllWithFavoriteMovie();

  @Query("select actor from Actor actor where actor.rating > :rating")
  List<Actor> findAllWithRatingHigher(@Param("rating") BigDecimal rating);

  @Query("select actor from Actor actor inner join actor.movies movie where movie.title = :movie")
  List<Actor> findAllActedInMovie(@Param("movie") String movie);
}
