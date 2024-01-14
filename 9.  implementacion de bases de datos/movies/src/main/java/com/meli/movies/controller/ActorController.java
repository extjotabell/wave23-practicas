package com.meli.movies.controller;

import com.meli.movies.service.actor.ActorServiceImpl;
import com.meli.movies.service.actor.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actors")
public class ActorController {

    IActorService service;

    public ActorController(ActorServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/favorite-movies")
    public ResponseEntity<?> getActorWithFavoriteMovies() {
        return new ResponseEntity<>(service.getActorWithFavoriteMovies(), HttpStatus.OK);
    }

}
