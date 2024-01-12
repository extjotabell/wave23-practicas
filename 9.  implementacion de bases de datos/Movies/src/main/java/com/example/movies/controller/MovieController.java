package com.example.movies.controller;

import com.example.movies.dto.ActorFavoriteMovieDTO;
import com.example.movies.dto.ActorSimpleDTO;
import com.example.movies.dto.MovieSimpleDTO;
import com.example.movies.service.ActorService;
import com.example.movies.service.MovieService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {
  private final MovieService movieService;

  public MovieController(MovieService movieService) {
    this.movieService = movieService;
  }
  @GetMapping("/rating-higher/{rating}")
  public ResponseEntity<List<MovieSimpleDTO>> getMoviesWithRatingHigher(@PathVariable BigDecimal rating){
    return ResponseEntity.ok(movieService.getMoviesWithRatingHigher(rating));
  }

  @GetMapping("/genre/{genre}")
  public ResponseEntity<List<MovieSimpleDTO>> getMoviesOfGenre(@PathVariable String genre){
    return ResponseEntity.ok(movieService.getMoviesOfGenre(genre));
  }
}
