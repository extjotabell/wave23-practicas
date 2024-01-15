package com.example.hql.repository;

import com.example.hql.model.Actor;
import com.example.hql.model.Episode;
import com.example.hql.model.Movie;
import com.example.hql.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IGenericRepo extends JpaRepository<Actor, Long> {
    @Query("FROM Actor a WHERE a.favoriteMovieId <> NULL")
    List<Actor> getActorsWithFavoriteMovie();

    @Query("FROM Actor a WHERE a.rating >=:rating")
    List<Actor> getActorsWithRatingGraterThan(@Param("rating") Double rating);

    @Query("SELECT a FROM Actor a INNER JOIN a.movies AS m")
    List<Actor> getActorsStarredIn(Long movieId);

    @Query("SELECT m FROM Actor a INNER JOIN a.movies AS m WHERE a.rating >=:rating")
    List<Movie> getMoviesWithActorsRatingGraterThan(Double rating);

    @Query("SELECT m FROM Genre g INNER JOIN g.movies AS m WHERE g.id =:genreId")
    List<Movie> getMoviesWithGenreLike(Long genreId);

    @Query("SELECT s FROM Genre g INNER JOIN g.series s GROUP BY s HAVING COUNT(s) >= :seasonsQuantity")
    List<Serie> getSeriesWithMoreSeasonsThan(@Param("seasonsQuantity") int seasonsQuantity);

    @Query("SELECT e FROM Actor a INNER JOIN a.episodes AS e WHERE a.id =:actorId")
    List<Episode> getSeriesEpisodeWithStarredActor(Long actorId);
}
