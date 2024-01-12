package com.example.movies.controller;

import com.example.movies.dto.ActorDTO;
import com.example.movies.dto.ActorFavoriteMovieDTO;
import com.example.movies.dto.ActorSimpleDTO;
import com.example.movies.models.Actor;
import com.example.movies.service.ActorService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/actors")
public class ActorController {
  private final ActorService actorService;

  public ActorController(ActorService actorService) {
    this.actorService = actorService;
  }

  @GetMapping("/favorite-movie")
  public ResponseEntity<List<ActorFavoriteMovieDTO>> getActorsWithFavoriteMovie(){
    return ResponseEntity.ok(actorService.getActorsWithFavoriteMovie());
  }

  @GetMapping("/rating-higher/{rating}")
  public ResponseEntity<List<ActorSimpleDTO>> getActorsWithRatingHigher(@PathVariable BigDecimal rating){
    return ResponseEntity.ok(actorService.getActorsWithRatingHigher(rating));
  }

  @GetMapping("/{movie}")
  public ResponseEntity<List<ActorSimpleDTO>> getActorsActedInMovie(@PathVariable String movie){
    return ResponseEntity.ok(actorService.getActorsActedInMovie(movie));
  }
}
