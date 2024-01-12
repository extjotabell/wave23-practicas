package com.meli.movies.controllers;

import com.meli.movies.dtos.response.SerieDTO;
import com.meli.movies.services.ISerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/series")
public class SerieController {

    private final ISerieService serieService;

    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping
    public ResponseEntity<List<SerieDTO>> getSeriesBySeasons(@RequestParam Integer seasons) {
        return new ResponseEntity<>(serieService.getSeriesBySeasons(seasons), HttpStatus.OK);
    }
}
