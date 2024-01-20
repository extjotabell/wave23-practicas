package com.implementationbd.movie.repository;

import com.implementationbd.movie.model.entity.Actor;
import com.implementationbd.movie.model.entity.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IEpisodeRepository extends CrudRepository<Actor, Long> {

    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @Query("SELECT ae.episode FROM ActorEpisode ae WHERE ae.actor = :actorId")
    List<Episode> getAllEpisodesWithActor(Long actorId);
}
