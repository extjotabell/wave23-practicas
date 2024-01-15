package com.example.ejercicioHQL.repository;

import com.example.ejercicioHQL.model.Actor;
import com.example.ejercicioHQL.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

    @Query("SELECT a " +
            "FROM Movie as m " +
            "JOIN m.actors as am " +
            "JOIN am.actor as a " +
            "WHERE m.title = ?1")
    List<Actor> findActorsByName(String titleName);

    @Query("SELECT m FROM Movie as m " +
            "JOIN m.actors as am " +
            "JOIN am.actor as a " +
            "WHERE a.rating > ?1")
    List<Movie> findByActorsRating(Double rating);

    @Query("SELECT m FROM Movie as m " +
            "JOIN m.genre as g " +
            "WHERE g.name = ?1")
    List<Movie> findByGenreName(String name);

}
