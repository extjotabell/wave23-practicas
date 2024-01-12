package com.meli.movies.repositories;

import com.meli.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IMovieRepository extends JpaRepository<Movie, Long> {

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT U FROM Movie U JOIN U.actors A WHERE A.rating > :rating OR A.rating = :rating")
    List<Movie> getMoviesByActorsRating(Double rating);
    //Listar todas las películas que pertenezcan al <género recibido por parametro>
    @Query("SELECT U FROM Movie U WHERE U.genre.name = :genre")
    List<Movie> getMoviesByGenre(String genre);
    //listar las mejores peliculas (rating y premios ) que sean del <año recibido por parámetro>
    @Query("SELECT U FROM Movie U WHERE YEAR(U.releaseDate) = :releaseDate ORDER BY U.rating DESC, U.awards DESC")
    List<Movie> getMoviesByReleaseDate(Integer releaseDate);

}