package com.meli.movies.repositories;

import com.meli.movies.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEpisodeRepository extends JpaRepository<Episode, Long> {
    @Query("SELECT e FROM Episode e JOIN e.actors a WHERE a.firstName = :firstName AND a.lastName = :lastName")
    List<Episode> getEpisodesByActor(String firstName, String lastName);
}
