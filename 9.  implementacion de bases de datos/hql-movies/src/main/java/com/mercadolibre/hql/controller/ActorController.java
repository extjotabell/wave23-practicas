package com.mercadolibre.hql.controller;

import com.mercadolibre.hql.dto.ActorDTO;
import com.mercadolibre.hql.service.ActorService;
import com.mercadolibre.hql.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {

    IActorService actorService;
    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/withFavoriteMovie")
    public ResponseEntity<List<ActorDTO>> findAllByFavoriteMovieIsNotNull() {
        return new ResponseEntity<>(actorService.findAllByFavoriteMovieIsNotNull(), HttpStatus.OK);
    }

    @GetMapping("/rating/greater/{rating}")
    public ResponseEntity<List<ActorDTO>> findAllByRatingGreaterThan(@PathVariable Double rating) {
        return new ResponseEntity<>(actorService.findAllByRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/movie/{title}")
    public ResponseEntity<List<ActorDTO>> findAllByActorMovie(@PathVariable String title) {
        return new ResponseEntity<>(actorService.findAllByActorMovie(title), HttpStatus.OK);
    }

}
