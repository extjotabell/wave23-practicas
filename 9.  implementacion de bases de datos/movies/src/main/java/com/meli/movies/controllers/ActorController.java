package com.meli.movies.controllers;

import com.meli.movies.dtos.response.ActorDTO;
import com.meli.movies.services.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/actors")
public class ActorController {

    private final IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/favorite-movies")
    public ResponseEntity<List<ActorDTO>> getActorsWithFavoriteMovie() {
        return new ResponseEntity<>(actorService.getActorsWithFavoriteMovie(), HttpStatus.OK);
    }

}
