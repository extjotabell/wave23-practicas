package com.practice.movies.repository;

import com.practice.movies.model.Actor;
import com.practice.movies.model.Episode;
import com.practice.movies.model.Movie;
import com.practice.movies.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenericRepository extends JpaRepository<Actor, Integer> {

    @Query("select a from Actor a where a.favouriteMovie is not null")
    List<Actor> listActorsWithFavMovie();

    @Query("select a from Actor a where a.rating >= :rating")
    List<Actor> listActorsWithRatingOver(@Param("rating") Double rating);

    @Query("select a from ActorMovie acmo " +
            "inner join acmo.actor a " +
            "inner join acmo.movie m " +
            "where m.id = :movieId")
    List<Actor> listActorsInMovie(@Param("movieId") Integer movieId);

    @Query("select m from ActorMovie acmo " +
            "inner join acmo.movie m " +
            "inner join acmo.actor a " +
            "where a.rating >= :rating")
    List<Movie> listMoviesWithActorsRatingOver(Double rating);

    @Query("select m from Movie m where m.genre.id = :genreId")
    List<Movie> listMoviesWithGenreId(Integer genreId);

    @Query("select distinct s from Season se " +
            "inner join se.serie s " +
            "where se.number > :number")
    List<Serie> listSeriesWithSeasonsNumberOver(Integer number);

    @Query("select e from ActorEpisode acep " +
            "inner join acep.actor a " +
            "inner join acep.episode e " +
            "where acep.actor.id = :actorId")
    List<Episode> listEpisodesWithActor(Integer actorId);
}
