package com.ejercicio.Movies.repository;

import com.ejercicio.Movies.model.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISeasonRepository extends JpaRepository<Season, Long> {
    @Query("SELECT season FROM Season season JOIN season.episodes episode JOIN episode.actors actor WHERE CONCAT(actor.firstName, ' ', actor.lastName) = :actor")
    List<Season> findSeasonsByActor(@Param("actor") String actor);
}
