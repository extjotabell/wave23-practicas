package com.meli.MoviesHQL.controller;

import com.meli.MoviesHQL.dto.ActorDto;
import com.meli.MoviesHQL.dto.EpisodeDto;
import com.meli.MoviesHQL.service.EpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EpisodeController {

    EpisodeService service;

    public EpisodeController(EpisodeService service) {
        this.service = service;
    }

    @GetMapping("/getEpisodeByActor/{actorId}")
    public ResponseEntity<List<EpisodeDto>> getEpisodeByActor(@PathVariable Long actorId) {
        List<EpisodeDto> episodes = service.findByActor(actorId);
        return ResponseEntity.status(200).body(episodes);
    }

}
