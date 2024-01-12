package com.meli.MoviesHQL.repository;

import com.meli.MoviesHQL.model.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends CrudRepository<Episode, Long> {

    @Query(
        "SELECT e FROM Episode e " +
        "JOIN ActorEpisode ae ON e.id = ae.episode.id " +
        "JOIN Actor a ON a.id = ae.actor.id " +
        "WHERE a.id = ?1"
    )
    List<Episode> findByActor(Long actorId);

}