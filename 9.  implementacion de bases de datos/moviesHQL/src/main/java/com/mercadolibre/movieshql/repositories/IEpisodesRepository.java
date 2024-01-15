package com.mercadolibre.movieshql.repositories;

import com.mercadolibre.movieshql.model.entities.Episodes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEpisodesRepository extends JpaRepository<Episodes, Long>{

    /**
     * List all episodes (of any series) where work an actor received as parameter.
     */
    @Query("SELECT episodes FROM Episodes episodes JOIN ActorEpisodes actor_episode ON episodes.id = actor_episode.episodes.id " +
            "JOIN Actors actors ON actors.id = actor_episode.actors.id WHERE actors.firstName = :actorName " +
            "AND actors.lastName = :actorLastName")
    List<Episodes> findEpisodesByActor(String actorName, String actorLastName);
}
