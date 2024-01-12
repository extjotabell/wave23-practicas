package com.meli.movies.repositories;

import com.meli.movies.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface IActorRepository extends JpaRepository<Actor, Long> {
    //Listar todos los actores que tengan declarada una película favorita.
    @Query("SELECT U FROM Actor U WHERE U.favoriteMovie IS NOT NULL")
    List<Actor> getActorsWithFavoriteMovie();
    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT U FROM Actor U WHERE U.rating > :rating OR U.rating = :rating")
    List<Actor> getActorsFilterByRating(Double rating);



}