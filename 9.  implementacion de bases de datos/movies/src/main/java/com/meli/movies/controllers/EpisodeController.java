package com.meli.movies.controllers;


import com.meli.movies.dtos.response.EpisodeDTO;
import com.meli.movies.services.IEpisodeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/episodes")
public class EpisodeController {

    private IEpisodeService episodeService;

    public EpisodeController(IEpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    public ResponseEntity<List<EpisodeDTO>> getEpisodesByActor(@RequestParam(name = "first_name") String firstName, @RequestParam(name="last_name") String lastName) {
        return ResponseEntity.ok(episodeService.getEpisodesByActor(firstName, lastName));
    }
}
