package com.example.movies.service;

import com.example.movies.dto.EpisodeDTO;
import com.example.movies.dto.EpisodeSimpleDTO;
import com.example.movies.repository.EpisodeRepository;
import com.example.movies.utils.Mapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class EpisodeService {

  private final EpisodeRepository episodeRepository;

  public EpisodeService(EpisodeRepository episodeRepository) {
    this.episodeRepository = episodeRepository;
  }

  public List<EpisodeSimpleDTO> episodesWhichActorWorks(Integer id){
    return episodeRepository.episodesWhichActorWorks(id).stream().map(Mapper::episodeToEpisodeDTO).collect(
        Collectors.toList());
  }
}
