package com.example.ejercicioHQL.repository;

import com.example.ejercicioHQL.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

    @Query("SELECT e FROM Episode as e " +
            "JOIN e.actors as ae " +
            "JOIN ae.actor as a " +
            "WHERE a.firstName = :firstName AND a.lastName = :lastName")
    List<Episode> findByActorsMatches(String firstName, String lastName);

}
