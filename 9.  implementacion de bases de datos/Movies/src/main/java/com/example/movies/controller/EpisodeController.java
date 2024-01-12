package com.example.movies.controller;

import com.example.movies.dto.EpisodeSimpleDTO;
import com.example.movies.service.EpisodeService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/episode")
@RestController
public class EpisodeController {

  private final EpisodeService episodeService;

  public EpisodeController(EpisodeService episodeService) {
    this.episodeService = episodeService;
  }

  @GetMapping("/works/actor/{id}")
  public ResponseEntity<List<EpisodeSimpleDTO>> getEpisodesWhichActorWorks(@PathVariable Integer id){
    return ResponseEntity.ok(episodeService.episodesWhichActorWorks(id));
  }
}
