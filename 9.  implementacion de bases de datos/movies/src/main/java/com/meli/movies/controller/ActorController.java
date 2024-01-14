package com.meli.movies.controller;

import com.meli.movies.service.actor.ActorServiceImpl;
import com.meli.movies.service.actor.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/actors")
public class ActorController {

    IActorService service;

    public ActorController(ActorServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/favorite-movies")
    public ResponseEntity<?> findByFavoriteMovieNotNull() {
        return new ResponseEntity<>(service.findByFavoriteMovieNotNull(), HttpStatus.OK);
    }

    @GetMapping("/rating-greater-than/{rating}")
    private ResponseEntity<?> findByRatingGreaterThan(@PathVariable BigDecimal rating) {
        return new ResponseEntity<>(service.findByRatingGreaterThan(rating), HttpStatus.OK);
    }
}
