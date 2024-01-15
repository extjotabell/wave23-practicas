package com.mercadolibre.movieshql.controller;

import com.mercadolibre.movieshql.model.dtos.ActorsDTO;
import com.mercadolibre.movieshql.services.IActorsService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorsController {


    private final IActorsService actorsService;

    public ActorsController(IActorsService actorService) {
        this.actorsService = actorService;
    }

    /**
     * List all actors with at least one favorite movie.
     */

    @GetMapping("/favorite-movie")
    public ResponseEntity<List<ActorsDTO>> findActorsWithOneFavoriteMovie() {
        return ResponseEntity.ok().body(actorsService.findActorsWithOneFavoriteMovie());
    }

    /**
     * List all actors with a rating higher than the value received as parameter.
     */

    @GetMapping("/rating")
    public ResponseEntity<List<ActorsDTO>> findActorsWithRatingHigherThanValue(@RequestParam("value") BigDecimal rating) {
        return ResponseEntity.ok().body(actorsService.findActorsWithRatingHigherThanValue(rating));
    }

    /**
     * List all actors that worked in a movie received as parameter.
     */

    @GetMapping("/movie")
    public ResponseEntity<List<ActorsDTO>> findActorsByMovieTitle(@RequestParam("movieTitle") String movieTitle) {
        return ResponseEntity.ok().body(actorsService.findActorsByMovieTitle(movieTitle));
    }
}
