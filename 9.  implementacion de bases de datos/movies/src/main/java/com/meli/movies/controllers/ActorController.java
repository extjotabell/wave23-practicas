package com.meli.movies.controllers;

import com.meli.movies.dtos.response.ActorDTO;
import com.meli.movies.services.IActorService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping
    public ResponseEntity<List<ActorDTO>> getActors(@RequestParam(required = false, defaultValue = "0.0") Double rating) {
        return new ResponseEntity<>(actorService.getActorsFilterByRating(rating), HttpStatus.OK);
    }

    @GetMapping("/favorite-movies")
    public ResponseEntity<List<ActorDTO>> getActorsWithFavoriteMovie() {
        return new ResponseEntity<>(actorService.getActorsWithFavoriteMovie(), HttpStatus.OK);
    }

}
