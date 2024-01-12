package com.meli.movies.controllers;


import com.meli.movies.dtos.response.MovieActorsDTO;
import com.meli.movies.services.IMovieService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final IMovieService movieService;

    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieActorsDTO>> getMovies() {
        return new ResponseEntity<>(movieService.getMoviesActors(), HttpStatus.OK);
    }
}
