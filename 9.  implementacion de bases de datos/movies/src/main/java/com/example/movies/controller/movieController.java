package com.example.movies.controller;

import com.example.movies.dto.ActorDto;
import com.example.movies.dto.ActorsListDto;
import com.example.movies.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class movieController {

    private final MovieService service;

    public movieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/actors/favoriteMovie")
    public ResponseEntity<ActorsListDto> findActorsWithFavoriteMovie() {
        return new ResponseEntity<>(service.findActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<ActorsListDto> findActorsWithRatingHigerThan(@RequestParam double rating) {
        return new ResponseEntity<>(service.findActorsWithRatingHigerThan(rating), HttpStatus.OK);
    }
    @GetMapping("/movie/{movieTitle}")
    public ResponseEntity<ActorsListDto> findActorsInMovie(@PathVariable String movieTitle) {
        return new ResponseEntity<>(service.findActorsInMovie(movieTitle), HttpStatus.OK);
    }

}
