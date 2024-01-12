package org.ejercicio.hql.controller;

import org.ejercicio.hql.service.IMoviesService;
import org.ejercicio.hql.service.MoviesServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MoviesController {

    private final IMoviesService service;

    public MoviesController(MoviesServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/actors/favorite-movies")
    public ResponseEntity<?> getActorsWithFavoriteMovies() {
        return new ResponseEntity<>(service.getActorsWithFavoriteMovies(), HttpStatus.OK);
    }

    @GetMapping("/actors")
    public ResponseEntity<?> getActorsWithRatingSuperior(@RequestParam Double rating) {
        return new ResponseEntity<>(service.getActorsWithRatingSuperior(rating), HttpStatus.OK);
    }

    @GetMapping("/actors/work/{movieId}")
    public ResponseEntity<?> getActorsWorkOnMovie(@PathVariable Long movieId) {
        return new ResponseEntity<>(service.getActorsWorkOnMovie(movieId), HttpStatus.OK);
    }

    @GetMapping("/rating/{valueRating}")
    public ResponseEntity<?> getMoviesWithRatingActors(@PathVariable Double valueRating) {
        return new ResponseEntity<>(service.getMoviesWithRatingActors(valueRating), HttpStatus.OK);
    }

    @GetMapping("/genre/{genreId}")
    public ResponseEntity<?> getMoviesGenre(@PathVariable Long genreId) {
        return new ResponseEntity<>(service.getMoviesGenre(genreId), HttpStatus.OK);
    }

    @GetMapping("/series/seasons/{valueSeasons}")
    public ResponseEntity<?> getSeriesWithSeasons(@PathVariable Integer valueSeasons) {
        return new ResponseEntity<>(service.getSeriesWithSeasons(valueSeasons), HttpStatus.OK);
    }

    @GetMapping("/series/episode-actor/{actorId}")
    public ResponseEntity<?> getEpisodesWhenActorWork(@PathVariable Long actorId) {
        return new ResponseEntity<>(service.getEpisodesWhenActorWork(actorId), HttpStatus.OK);
    }
}
