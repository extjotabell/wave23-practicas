package com.jpa.hql.repository;

import com.jpa.hql.model.entity.GenreEntity;
import com.jpa.hql.model.entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Set;
@Repository
public interface IMovieRepository extends JpaRepository<MovieEntity, Integer> {

    /* This exercise has an ambiguity,
     *     in my opinión all the actors must have more than the param rating to return the movie!
     */
    @Query("SELECT Movie1 FROM (SELECT M1 AS Movie1" +
            "   FROM ActorEntity AS Actor" +
            "   JOIN Actor.moviesEntities AS M1 " +
            "   WHERE Actor.rating > :rating" +
            "   GROUP BY (M1.id)" +
            "   HAVING COUNT(*) = " +
                "   (SELECT COUNT(*) AS total_actors " +
                "   FROM ActorEntity AS Actor" +
                "   JOIN Actor.moviesEntities AS M2 " +
                "   WHERE M2.id = M1.id" +
                "   GROUP BY M2.id) " +
            "   )"
            )
    Set<MovieEntity> findByActorsWithRatingGreaterThan(@Param("rating") BigDecimal rating);
    Set<MovieEntity> findByGenreEquals(GenreEntity genre);
}
