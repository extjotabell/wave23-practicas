package com.mercadolibre.hql.repository;

import com.mercadolibre.hql.entity.Episodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository extends JpaRepository<Episodes, Integer> {

    // Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @Query("FROM Episodes e INNER JOIN ActorEpisode ae ON e.id = ae.episodesByEpisodeId.id INNER JOIN Actors a ON ae.actorsByActorId.id = a.id WHERE a.lastName = :lastName")
    List<Episodes> findAllByActorLastName(@Param("lastName") String lastName);
}
