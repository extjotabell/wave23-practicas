package com.mercadolibre.hql.repository;

import com.mercadolibre.hql.entity.Actors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorRepository extends JpaRepository<Actors, Integer> {

    // Listar todos los actores que tengan declarada una película favorita
    @Query("FROM Actors a WHERE a.moviesByFavoriteMovieId IS NOT NULL")
    List<Actors> findAllByFavoriteMovieIsNotNull();

    // Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @Query("FROM Actors a WHERE a.rating > :rating")
    List<Actors> findAllByRatingGreaterThan(@Param("rating") Double rating);

    // Listar todos los actores que trabajan en la <película recibida por parámetro>
    @Query("FROM Actors a JOIN ActorMovie am ON a.id = am.actorsByActorId.id JOIN Movies m ON am.moviesByMovieId.id = m.id WHERE m.title = :title")
    List<Actors> findAllByActorMovie(@Param("title") String title);
}
