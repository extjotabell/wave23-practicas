package com.example.movies.controller;

import com.example.movies.dto.ActorsListDto;
import com.example.movies.dto.MoviesListDto;
import com.example.movies.service.actor.ActorService;
import com.example.movies.service.movie.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class movieController {

    private final ActorService ActorService;
    private final MovieService MovieService;

    public movieController(ActorService service, MovieService movieservice) {
        this.ActorService = service;
        MovieService = movieservice;
    }

    @GetMapping("/actors/favoriteMovie")
    public ResponseEntity<ActorsListDto> findActorsWithFavoriteMovie() {
        return new ResponseEntity<>(ActorService.findActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ActorsListDto> findActorsWithRatingHigerThan(@RequestParam double rating) {
        return new ResponseEntity<>(ActorService.findActorsWithRatingHigerThan(rating), HttpStatus.OK);
    }
    @GetMapping("/movie/{movieTitle}")
    public ResponseEntity<ActorsListDto> findActorsInMovie(@PathVariable String movieTitle) {
        return new ResponseEntity<>(ActorService.findActorsInMovie(movieTitle), HttpStatus.OK);
    }

    @GetMapping("/{genre}")
    public ResponseEntity<MoviesListDto> findMoviesWithGenre(@PathVariable String genre) {
        return new ResponseEntity<>(MovieService.findMoviesWithGenre(genre), HttpStatus.OK);
    }



}
