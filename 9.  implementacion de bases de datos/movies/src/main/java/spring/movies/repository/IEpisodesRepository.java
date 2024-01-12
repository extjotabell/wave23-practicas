package spring.movies.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.movies.dto.EpisodeDto;
import spring.movies.model.Actor;
import spring.movies.model.Episode;

import java.util.List;

@Repository
public interface IEpisodesRepository extends JpaRepository<Episode,Long> {

    @Query("SELECT e FROM Episode e JOIN e.actorEpisodes ae JOIN ae.actor a WHERE a.id = :parametroActor")
    List<EpisodeDto> findByActor(@Param("parametroActor") Long parametroActor);

    @Query("SELECT e FROM Episode e JOIN e.actorEpisodes ae JOIN ae.actor a WHERE a.lastName LIKE %:parametroNombreActor%")
    List<EpisodeDto> findByActorNombre(@Param("parametroNombreActor") String parametroNombreActor);
}
