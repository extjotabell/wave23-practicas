package com.mercadolibre.movieshql.controller;

import com.mercadolibre.movieshql.model.dtos.EpisodesDTO;
import com.mercadolibre.movieshql.services.IEpisodesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EpisodesController {

    private final IEpisodesService episodesService;

    public EpisodesController(IEpisodesService episodesService) {
        this.episodesService = episodesService;
    }

    /**
     * Controller to list all episodes (of any series) where works the actor received as parameter.
     */

    @GetMapping("/episodes")
    public ResponseEntity<List<EpisodesDTO>> findEpisodesOfAnySeriesByActor(@RequestParam("name") String name,
                                                                            @RequestParam("lastName") String lastname) {
        return ResponseEntity.ok().body(episodesService.findEpisodesOfAnySeriesByActor(name, lastname));
    }
}
