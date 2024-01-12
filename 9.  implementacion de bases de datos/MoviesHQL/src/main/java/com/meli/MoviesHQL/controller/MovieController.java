package com.meli.MoviesHQL.controller;

import com.meli.MoviesHQL.dto.ActorDto;
import com.meli.MoviesHQL.dto.MovieDto;
import com.meli.MoviesHQL.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MovieController {

    MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/getByActorsRatingGreaterThan/{rating}")
    public ResponseEntity<List<MovieDto>> getByActorsRatingGreaterThan(@PathVariable Double rating) {
        List<MovieDto> movies = service.findByActorsRatingGreaterThan(rating);
        return ResponseEntity.status(200).body(movies);
    }

    @GetMapping("/getByGenre/{genreId}")
    public ResponseEntity<List<MovieDto>> getByGenre(@PathVariable Long genreId) {
        List<MovieDto> movies = service.findByGenre(genreId);
        return ResponseEntity.status(200).body(movies);
    }

}
