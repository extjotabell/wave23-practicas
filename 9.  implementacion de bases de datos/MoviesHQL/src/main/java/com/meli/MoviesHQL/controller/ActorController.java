package com.meli.MoviesHQL.controller;

import com.meli.MoviesHQL.dto.ActorDto;
import com.meli.MoviesHQL.service.ActorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ActorController {

    ActorService service;

    public ActorController(ActorService service) {
        this.service = service;
    }

    @GetMapping("/getActorsWithFavoriteMovie")
    public ResponseEntity<List<ActorDto>> getActorsWithFavoriteMovie() {
        List<ActorDto> actors = service.findByFavoriteMovieIsNotNull();
        return ResponseEntity.status(200).body(actors);
    }

    @GetMapping("/getActorsWithRatingGreaterThan/{rating}")
    public ResponseEntity<List<ActorDto>> getActorsWithRatingGreaterThan(@PathVariable Double rating) {
        List<ActorDto> actors = service.findByRatingIsGreaterThanEqual(rating);
        return ResponseEntity.status(200).body(actors);
    }

    @GetMapping("/getActorsByMovie/{movieId}")
    public ResponseEntity<List<ActorDto>> getActorsByMovie(@PathVariable Long movieId) {
        List<ActorDto> actors = service.findByMovie(movieId);
        return ResponseEntity.status(200).body(actors);
    }
}
