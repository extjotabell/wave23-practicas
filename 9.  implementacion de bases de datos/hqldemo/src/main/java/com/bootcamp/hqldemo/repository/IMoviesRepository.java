package com.bootcamp.hqldemo.repository;

import com.bootcamp.hqldemo.model.entity.Actor;
import com.bootcamp.hqldemo.model.entity.Episode;
import com.bootcamp.hqldemo.model.entity.Movie;
import com.bootcamp.hqldemo.model.entity.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoviesRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT A FROM Actor AS A WHERE A.favouriteMovie.title IS NOT NULL")
    List<Actor> getAllActorsWithFavouriteMovies();

    @Query("SELECT A FROM Actor AS A WHERE A.rating > :rating")
    List<Actor> getAllActorsRating(@Param("rating") Double rating);

    @Query("SELECT AM FROM ActorMovie AS AM WHERE AM.movie.title LIKE :movie")
    List<Actor> getAllActorsFromMovie(@Param("movie") String movie);

    @Query("SELECT AM FROM ActorMovie AS AM WHERE AM.actor.rating > :rating")
    List<Movie> getAllMoviesWithActorsRating(@Param("rating") Double rating);

    @Query("SELECT M FROM Movie AS M WHERE M.genre.name LIKE :genre")
    List<Movie> getAllMoviesByGenre(@Param("genre") String genre);

    @Query("SELECT E.season.title FROM Episode AS E WHERE E.season.number > :seasons")
    List<Serie> getAllSeriesWithAmountOfSeasons(@Param("seasons") Integer seasons);

    @Query("SELECT AE.episode FROM ActorEpisode AS AE WHERE AE.actor.firstName LIKE :actor OR AE.actor.lastName LIKE :actor")
    List<Episode> getEpisodeFromActor(@Param("actor") String actor);

}
