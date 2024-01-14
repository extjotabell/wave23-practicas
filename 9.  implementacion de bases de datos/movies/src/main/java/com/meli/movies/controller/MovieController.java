package com.meli.movies.controller;

import com.meli.movies.service.movie.IMovieService;
import com.meli.movies.service.movie.MovieServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/movies")
public class MovieController {

    IMovieService service;

    public MovieController(MovieServiceImpl service) { this.service = service; }

    @GetMapping("/actors/rating-greater-than/{rating}")
    private ResponseEntity<?> findByActorRatingGreaterThan(@PathVariable BigDecimal rating) {
        return new ResponseEntity<>(service.findByActorRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    private ResponseEntity<?> findByGenre(@PathVariable String genre) {
        return new ResponseEntity<>(service.findByGenre(genre), HttpStatus.OK);
    }
}
