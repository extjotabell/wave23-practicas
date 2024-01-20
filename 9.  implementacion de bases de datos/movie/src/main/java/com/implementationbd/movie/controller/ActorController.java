package com.implementationbd.movie.controller;

import com.implementationbd.movie.model.dto.ActorDto;
import com.implementationbd.movie.service.interfaces.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/actor")
public class ActorController {

    @Autowired
    IActorService service;
    @GetMapping("/with-favorite-movie")
    public ResponseEntity<List<ActorDto>> getActorsWithFavoriteMovie() {
        return new ResponseEntity<>(service.getActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    @GetMapping("/with-rating-greater-than/{rating}")
    public ResponseEntity<List<ActorDto>> getActorsWithRatingGreaterThan(@PathVariable double rating) {
        return new ResponseEntity<>(service.getActorsWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/worked-in-movie/{movieId}")
    public ResponseEntity<List<ActorDto>> getActorsWorkedIn(@PathVariable Long movieId) {
        return new ResponseEntity<>(service.getActorsWorkedIn(movieId), HttpStatus.OK);
    }
}
