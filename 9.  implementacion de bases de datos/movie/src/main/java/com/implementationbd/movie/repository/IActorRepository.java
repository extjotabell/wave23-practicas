package com.implementationbd.movie.repository;

import com.implementationbd.movie.model.entity.Actor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IActorRepository extends CrudRepository<Actor, Long> {

    //Listar todos los actores que tengan declarada una película favorita.
    @Query("FROM Actor A WHERE A.favoriteMovie IS NOT NULL")
    List<Actor> getActorsWithFavoriteMovie();

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @Query("SELECT a FROM Actor a WHERE a.rating > :rating")
    List<Actor> getActorsWithRatingGreaterThan(double rating);

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("SELECT am.actor FROM ActorMovie am WHERE am.movie.id = :movieId")
    List<Actor> getActorsWorkedIn(Long movieId);
}