package com.mercadolibre.movieshql.controller;

import com.mercadolibre.movieshql.model.dtos.MoviesDTO;
import com.mercadolibre.movieshql.services.IMoviesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final IMoviesService moviesService;

    public MoviesController(IMoviesService moviesService) {
        this.moviesService = moviesService;
    }

    /**
     * List all movies whose actors have a rating higher than the received as parameter.
     */
    @GetMapping("/rating")
    public ResponseEntity<List<MoviesDTO>> findActorsWithRatingHigherThanRatingValue(@RequestParam("value") Double rating) {
        return ResponseEntity.ok().body(moviesService.findActorsWithRatingHigherThanRatingValue(rating));
    }

    /**
     * List all movies belong the genre received as parameter.
     * Genres can be: Comedia, Drama, Ciencia Ficcion, Suspenso
     */
   @GetMapping("/genres")
    public ResponseEntity<List<MoviesDTO>> findMoviesByGenre(@RequestParam("title") String genres) {
       return ResponseEntity.ok().body(moviesService.findMoviesByGenre(genres));
   }
}
