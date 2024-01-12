package com.example.movies.repository;

import com.example.movies.models.Episode;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EpisodeRepository extends JpaRepository<Episode, Integer> {

  @Query("select episode from Episode episode inner join episode.actors actors where actors.id = :id")
  List<Episode> episodesWhichActorWorks(Integer id);
}
