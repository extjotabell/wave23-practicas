package com.meli.MoviesHQL.controller;

import com.meli.MoviesHQL.dto.MovieDto;
import com.meli.MoviesHQL.dto.SerieDto;
import com.meli.MoviesHQL.service.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SerieController {

    SerieService service;

    public SerieController(SerieService service) {
        this.service = service;
    }

    @GetMapping("/getBySeasonsCountGreaterThanEqual/{seasons}")
    public ResponseEntity<List<SerieDto>> getBySeasonsCountGreaterThanEqual(@PathVariable Integer seasons) {
        List<SerieDto> movies = service.findBySeasonsCountGreaterThanEqual(seasons);
        return ResponseEntity.status(200).body(movies);
    }

}
