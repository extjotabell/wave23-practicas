package com.example.movieshql.repository;

import com.example.movieshql.model.Actor;
import com.example.movieshql.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {

    @Query("SELECT ae.actor FROM ActorEpisode ae WHERE ae.actor.id = :actorId")
    List<Episode> findEpisodesByActor(@Param("actorId") Long actorId);
}