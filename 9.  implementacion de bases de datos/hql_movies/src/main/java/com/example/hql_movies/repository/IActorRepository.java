package com.example.hql_movies.repository;

import com.example.hql_movies.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<Actor,Long> {
    @Query("SELECT a from Actor a")
    List<Actor> findAllactors();

    @Query("SELECT a.firstName FROM Actor a WHERE a.favoriteMovie.title = 'Titanic'")
    List<String> findFirstName();

    @Query("SELECT a FROM Actor a WHERE a.favoriteMovie.title IS NOT NULL ORDER BY a.id asc")
    List<Actor> findAllactorsWithFavoriteMovie();

    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> findActorRating(@Param("rating") Double rating);

    @Query("SELECT m.actor FROM ActorMovie m WHERE m.movie.title = :title")
    List<Actor> findMovie(@Param("title") String title);

    @Query("SELECT m.movie FROM ActorMovie m WHERE m.actor.rating > :rating")
    List<Movie> findMovieActorRating(@Param("rating") Double rating);

    @Query("SELECT m FROM Movie m WHERE m.genre.name = :genre")
    List<Movie> findMovieGender(@Param("genre") String genre);

    @Query("SELECT s FROM Serie s")
    List<Serie> findSerieRating();

    @Query("SELECT m FROM Movie m")
    List<Movie> findAllMovie();

    @Query("SELECT s FROM Season s")
    List<Season> findAllSeason();

    @Query("SELECT e FROM Episode e")
    List<Episode> findEpisodes();

    @Query("SELECT e.season.serie FROM Episode e WHERE e.season.number > :number")
    List<Serie> findSerieSeasonNumber(@Param("number") Integer number);

    @Query("SELECT a.episode FROM ActorEpisode a WHERE a.actor.firstName = :actor")
    List<Episode> findEpisodeActor(@Param("actor") String actor);
}
