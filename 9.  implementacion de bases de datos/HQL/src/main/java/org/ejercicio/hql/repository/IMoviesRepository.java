package org.ejercicio.hql.repository;

import org.ejercicio.hql.model.entity.Actor;
import org.ejercicio.hql.model.entity.Episode;
import org.ejercicio.hql.model.entity.Movie;
import org.ejercicio.hql.model.entity.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public interface IMoviesRepository extends CrudRepository<Actor, Long> {

    @Query("FROM Actor a " +
            "WHERE a.favoriteMovieId IS NOT NULL")
    List<Actor> getActorWithFavoriteMovie();

    @Query("FROM Actor a " +
            "WHERE a.rating > :rating")
    List<Actor> getActorsWithRatingSuperior(Double rating);

    @Query("FROM Actor a " +
            "JOIN ActorMovie am ON a.id = am.actor.id " +
            "JOIN Movie m ON am.movie.id = m.id " +
            "WHERE m.id = :movie")
    List<Actor> getActorsWorkOnMovie(Long movie);

    @Query("FROM Movie m " +
            "WHERE NOT EXISTS (" +
            "SELECT a FROM Actor a " +
            "JOIN a.actorMovies am " +
            "WHERE am.movie.id = m.id AND a.rating <= :valueRating" +
            ")")
    List<Movie> getMoviesWithRatingActors(Double valueRating);

    @Query("FROM Movie m " +
            "JOIN Genre g ON m.genreId = g.id " +
            "WHERE g.id = :genreId")
    List<Movie> getMoviesGenre(Long genreId);

    @Query("FROM Serie s " +
            "JOIN Season ss ON s.id = ss.serieId " +
            "GROUP BY s.id " +
            "HAVING COUNT(*) > :valueSeasons")
    List<Serie> getSeriesWithSeasons(Integer valueSeasons);

    @Query("FROM Episode e " +
            "JOIN ActorEpisode ae ON e.id = ae.episode.id " +
            "JOIN Actor a ON a.id = ae.actor.id " +
            "WHERE a.id = :actorId")
    List<Episode> getEpisodesWhenActorWork(Long actorId);
}
