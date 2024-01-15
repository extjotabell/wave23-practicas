package com.example.Hql.repository;

import com.example.Hql.model.dto.EpisodeDto;
import com.example.Hql.model.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IEpisodeRepository extends JpaRepository<Episode,Long> {

    @Query("SELECT e FROM Episode e JOIN e.actorEpisodes ae JOIN ae.actor a WHERE a.lastName LIKE %:parametroNombreActor%")
    List<EpisodeDto> findByActorNombre(@Param("parametroNombreActor") String parametroNombreActor);
}
