package com.example.ejercicioHQL.repository;

import com.example.ejercicioHQL.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    @Query("SELECT u FROM Actor u WHERE u.favoriteMovie IS NOT NULL")
    List<Actor> findFavoriteMovieNotNull();

    @Query("SELECT u FROM Actor u WHERE u.rating > ?1")
    List<Actor> findAllByRating(Double rating);

}
