package com.example.movies.repository;

import com.example.movies.model.entities.Actors;
import com.example.movies.model.entities.Episodes;
import com.example.movies.model.entities.Movies;
import com.example.movies.model.entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenericRepository extends JpaRepository<Actors,Long> {

    //Listar todos los actores que tengan declarada una película favorita.
    @Query("SELECT a FROM Actors a WHERE a.favoriteMovieId IS NOT NULL")
    List<Actors> getActorsWithFavorteMovie();

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT a FROM Actors a WHERE a.rating >=:rating")
    List<Actors> getActorsRatingThant(@Param("rating") Double rating);

    //Listar todos los actores que trabajan en la <película recibida por parámetro
    @Query("SELECT a FROM Actors a INNER JOIN a.movies AS m")
    List<Actors> getActorsWorkIn(Long movieId);

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT m FROM Actors a INNER JOIN a.movies AS m WHERE a.rating >=:rating")
    List<Movies> getMoviesWithActorsRating(Double rating);

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @Query("SELECT m FROM Genres g INNER JOIN g.movies AS m WHERE g.id =:genreId")
    List<Movies> getMoviesWithGenreIn(Long genreId);

    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @Query("SELECT s FROM Genres g INNER JOIN g.series AS s GROUP BY g.ID HAVING COUNT(s) >= :seasonQ")
    //@Query("SELECT s FROM Series s join s.seasons se WHERE se.number > :seasonQ")
    List<Series> getSeriesWithMore(int seasonQ);

    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @Query("SELECT e FROM Actors a INNER JOIN a.episodes AS e WHERE a.id =:actorId")
    List<Episodes> getEpisodesWithActor(Long actorId);

}