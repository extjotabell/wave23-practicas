package meli.bootcamp.jpa.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import meli.bootcamp.jpa.model.dto.ActorInfoDto;
import meli.bootcamp.jpa.service.ActorService;

@RestController
@RequestMapping("actor")
public class ActorController {
  private final ActorService service;

  public ActorController(ActorService service) {
    this.service = service;
  }

  @GetMapping("favorite")
  public ResponseEntity<List<ActorInfoDto>> getAllWithFavouriteMovie() {
    return ResponseEntity.ok(this.service.getAllWithFavouriteMovie());
  }

  @GetMapping("rating/{minRating}")
  public ResponseEntity<List<ActorInfoDto>> geByRatingGreaterThan(@PathVariable("minRating") BigDecimal minRating) {
    return ResponseEntity.ok(this.service.getByRatingGreaterThan(minRating));
  }

  @GetMapping("movie/{movieTitle}")
  public ResponseEntity<List<ActorInfoDto>> geByRatingGreaterThan(@PathVariable("movieTitle") String movieTitle) {
    return ResponseEntity.ok(this.service.getByWorkingMovieTitle(movieTitle));
  }
}
