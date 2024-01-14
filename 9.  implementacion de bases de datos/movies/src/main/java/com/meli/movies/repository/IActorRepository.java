package com.meli.movies.repository;

import com.meli.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IActorRepository extends JpaRepository<Actor, Long> {

    @Query("FROM Actor a WHERE a.favoriteMovie IS NOT NULL")
    List<Actor> findAllActorsWithFavoriteMovie();

    @Query("FROM Actor a WHERE a.rating > :rating")
    List<Actor> findByRatingGreaterThan(@Param("rating") BigDecimal rating);
}
