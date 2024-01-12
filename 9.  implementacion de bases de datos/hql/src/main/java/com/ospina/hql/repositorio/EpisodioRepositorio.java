package com.ospina.hql.repositorio;

import com.ospina.hql.modelo.entidad.Episode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodioRepositorio extends CrudRepository<Episode, Long> {

    @Query("SELECT e FROM Episode e JOIN e.actors a WHERE LOWER(a.firstName) LIKE LOWER(CONCAT('%', :actorName, '%'))")
    List<Episode> encontrarEpisodiosPorActor(@Param("actorName") String actorName);

}
