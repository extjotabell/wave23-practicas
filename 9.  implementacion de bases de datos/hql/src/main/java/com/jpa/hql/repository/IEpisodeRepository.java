package com.jpa.hql.repository;

import com.jpa.hql.model.entity.EpisodeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IEpisodeRepository extends JpaRepository<EpisodeEntity, Integer> {
    @Query("SELECT Episode FROM ActorEntity AS Actor " +
            "JOIN Actor.episodesEntities AS Episode " +
            "WHERE Actor.firstName = :firstName AND Actor.lastName = :lastName")
    Set<EpisodeEntity> findByActorNameEquals(String firstName,  String lastName);
}
