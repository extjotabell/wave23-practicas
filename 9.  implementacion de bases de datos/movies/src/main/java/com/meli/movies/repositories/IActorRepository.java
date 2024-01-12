package com.meli.movies.repositories;

import com.meli.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {
    //Listar todos los actores que tengan declarada una pelicula favorita.
    @Query("SELECT U FROM Actor U WHERE U.favoriteMovie IS NOT NULL")
    List<Actor> getActorsWithFavoriteMovie();
    //Listar todos los actores que tengan rating superior a <valor recibido por parametro>
    @Query("SELECT U FROM Actor U WHERE U.rating > :rating OR U.rating = :rating")
    List<Actor> getActorsFilterByRating(Double rating);
    //Listar todos los actores que trabajan en la <película recibida por parametro>
    @Query("SELECT U FROM Actor U JOIN U.movies M WHERE M.title = :title")
    List<Actor> getActorsByMoviesTitle(String title);



}