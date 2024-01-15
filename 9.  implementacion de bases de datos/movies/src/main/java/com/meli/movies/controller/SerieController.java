package com.meli.movies.controller;

import com.meli.movies.service.serie.ISerieService;
import com.meli.movies.service.serie.SerieServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SerieController {
    ISerieService service;

    public SerieController(SerieServiceImpl service) { this.service = service; }

    @GetMapping("/seasons-greater-than/{seasons}")
    public ResponseEntity<?> findBySeasonGreaterThan(@PathVariable Integer seasons) {
        return new ResponseEntity<>(service.findBySeasonGreaterThan(seasons), HttpStatus.OK);
    }

    @GetMapping("/episodes/{actor}")
    public ResponseEntity<?> findEpisodesByActor(@PathVariable String actor) {
        return new ResponseEntity<>(service.findEpisodesByActor(actor), HttpStatus.OK);
    }
}
