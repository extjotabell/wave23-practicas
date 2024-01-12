package com.meli.movies.repositories;

import com.meli.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IMovieRepository extends JpaRepository<Movie, Long> {

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT U FROM Movie U JOIN U.actors A WHERE A.rating > :rating OR A.rating = :rating")
    List<Movie> getMoviesByActorsRating(Double rating);
}
