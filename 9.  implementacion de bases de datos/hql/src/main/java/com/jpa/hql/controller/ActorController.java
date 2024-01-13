package com.jpa.hql.controller;

import com.jpa.hql.model.dto.ActorDTO;
import com.jpa.hql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private IActorService actorService;
    @GetMapping("/withFavoriteMovie")
    public ResponseEntity<Set<ActorDTO>> getActorsWithFavoriteMovie() {
        return ResponseEntity.ok(actorService.getAllActorsWithFavoriteMovie());
    }

    @GetMapping(value = "", params = {"rating", "!movie"})
    public ResponseEntity<Set<ActorDTO>> getActorsWithRatingGreaterThan(
            @RequestParam(name = "rating") BigDecimal rating
    ) {
        return ResponseEntity.ok(actorService.getAllActorsWithRatingGraterThan(rating));
    }

    @GetMapping(value = "", params = {"!rating", "movie"})
    public ResponseEntity<Set<ActorDTO>> getActorsWhoParticipatedInMovie(
            @RequestParam(name = "movie") String movieName
    ) {
        return ResponseEntity.ok(actorService.getAllActorsWhoParticipatedInMovie(movieName));
    }

}
