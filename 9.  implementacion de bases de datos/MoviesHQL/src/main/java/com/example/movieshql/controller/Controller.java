package com.example.movieshql.controller;

import com.example.movieshql.service.actor.ActorService;
import com.example.movieshql.service.episode.EpisodeService;
import com.example.movieshql.service.movie.MovieService;
import com.example.movieshql.service.serie.SerieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    private final ActorService actorService;
    private final MovieService movieServcie;
    private final EpisodeService episodeService;
    private final SerieService serieService;

    public Controller(ActorService actorService, MovieService movieServcie, EpisodeService episodeService, SerieService serieService) {
        this.actorService = actorService;
        this.movieServcie = movieServcie;
        this.episodeService = episodeService;
        this.serieService = serieService;
    }

    @GetMapping("/findActorsWithFavoriteMovie")
    public ResponseEntity<?> findActorsWithFavoriteMovie() {
        return ResponseEntity.ok().body(actorService.findActorsWithFavoriteMovie());
    }

    @GetMapping("/findActorsWithRatingHigherThan/{rating}")
    public ResponseEntity<?> findActorsWithRatingHigherThan(@PathVariable Double rating) {
        return ResponseEntity.ok().body(actorService.findActorsWithRatingHigherThan(rating));
    }

    @GetMapping("/findActorsByFavoriteMovie/{movieId}")
    public ResponseEntity<?> findActorsByFavoriteMovie(@PathVariable Long movieId) {
        return ResponseEntity.ok().body(actorService.findActorsByFavoriteMovie(movieId));
    }

    @GetMapping("/findMoviesByActorsWithHigherRatingThan/{rating}")
    public ResponseEntity<?> findMoviesByActorsWithHigherRatingThan(@PathVariable Double rating) {
        return ResponseEntity.ok().body(movieServcie.findMoviesByActorsWithHigherRatingThan(rating));
    }

    @GetMapping("/findMoviesByGenre/{genreId}")
    public ResponseEntity<?> findMoviesByGenre(@PathVariable Long genreId) {
        return ResponseEntity.ok().body(movieServcie.findMoviesByGenre(genreId));
    }

    @GetMapping("/findEpisodesByActor/{actorId}")
    public ResponseEntity<?> findEpisodesByActor(@PathVariable Long actorId) {
        return ResponseEntity.ok().body(episodeService.findEpisodesByActor(actorId));
    }

    @GetMapping("/findSeriesBySeasonAmountHigherThan/{amount}")
    public ResponseEntity<?> findSeriesBySeasonAmountHigherThan(@PathVariable int amount) {
        return ResponseEntity.ok().body(serieService.findSeriesBySeasonAmountHigherThan(amount));
    }
}
