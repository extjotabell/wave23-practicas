package com.example.Hql.controller;


import com.example.Hql.service.MoviesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/movies")
public class MoviesController {

    private final MoviesService service;

    public MoviesController(MoviesService service) {
        this.service = service;
    }

    @GetMapping("/actors/pelicula/favorita")
    public ResponseEntity<?> findFavoriteMovieOfActor() {
        return ResponseEntity.ok(service.findFavoriteMovieOfActor());
    }

    @GetMapping("/actors/rating/{actorRating}")
    public ResponseEntity<?> getActorsByRating(@PathVariable Double actorRating){
        return ResponseEntity.ok(service.getActorsByRating(actorRating));
    }

    @GetMapping("/actors/movie/{movieId}")
    public ResponseEntity<?> getActorsThatWorkIn(@PathVariable Long movieId){
        return  ResponseEntity.ok(service.getActorsThatWasInMovie(movieId));
    }

    @GetMapping("/movies/rating/{ratingActor}")
    public ResponseEntity<?> getMoviesActorRating(@PathVariable Double ratingActor){
        return  ResponseEntity.ok(service.getMoviesByActorRating(ratingActor));
    }

    @GetMapping("/movies/genre/{genreId}")
    public ResponseEntity<?> getMoviesByGenre(@PathVariable Long genreId){
        return  ResponseEntity.ok(service.getMoviesByGenre(genreId));
    }

    @GetMapping("/series/seasons/{seasons}")
    public ResponseEntity<?> getByNumeroTemporadasGreaterThan(@PathVariable Integer seasons){
        return ResponseEntity.ok(service.getNumeroTemporadasGreaterThan(seasons));
    }

    @GetMapping("/episodes/actor/{actorName}")
    public ResponseEntity<?> getEpisodesByActorName(@PathVariable String actorName){
        return ResponseEntity.ok(service.getEpisodesByActor(actorName));
    }


}
