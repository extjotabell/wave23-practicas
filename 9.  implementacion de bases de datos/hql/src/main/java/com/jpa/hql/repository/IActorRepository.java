package com.jpa.hql.repository;

import com.jpa.hql.model.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;

@Repository
public interface IActorRepository extends JpaRepository<ActorEntity, Integer> {

    @Query(value = "SELECT Actor FROM ActorEntity AS Actor WHERE Actor.favoriteMovie IS NOT NULL")
    Set<ActorEntity> findAllWithFavoriteMovie();

    @Query(value = "SELECT Actor FROM ActorEntity AS Actor WHERE Actor.rating > :rating")
    Set<ActorEntity> findByRatingGreaterThan(@Param("rating") BigDecimal rating);

    @Query("SELECT Actor FROM ActorEntity AS Actor JOIN Actor.moviesEntities AS movie " +
            "WHERE movie.title = :title")
    Set<ActorEntity> findByMovie(@Param("title") String title);


}
