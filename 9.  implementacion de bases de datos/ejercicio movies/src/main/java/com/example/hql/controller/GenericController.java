package com.example.hql.controller;

import com.example.hql.dto.ActorsListDTO;
import com.example.hql.dto.EpisodesListDTO;
import com.example.hql.dto.MoviesListDTO;
import com.example.hql.dto.SeriesListDTO;
import com.example.hql.service.GenericServiceImp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {
    private final GenericServiceImp service;

    public GenericController(GenericServiceImp service) {
        this.service = service;
    }

    @GetMapping ("/getActorsWithFavoriteMovie")
    public ResponseEntity<ActorsListDTO> getActorsWithFavoriteMovie() {
        return ResponseEntity.ok(service.getActorsWithFavoriteMovie());
    }

    @GetMapping ("/getActorsWithRatingGraterThan/{rating}")
    public ResponseEntity<ActorsListDTO> getActorsWithRatingGraterThan(@PathVariable Double rating) {
        return ResponseEntity.ok(service.getActorsWithRatingGraterThan(rating));
    }

    @GetMapping ("/getActorsStarredIn/{movieId}")
    public ResponseEntity<ActorsListDTO> getActorsStarredIn(@PathVariable Long movieId) {
        return ResponseEntity.ok(service.getActorsStarredIn(movieId));
    }

    @GetMapping ("/getMoviesWithActorsRatingGraterThan/{rating}")
    public ResponseEntity<MoviesListDTO> getMoviesWithActorsRatingGraterThan(@PathVariable Double rating) {
        return ResponseEntity.ok(service.getMoviesWithActorsRatingGraterThan(rating));
    }

    @GetMapping ("/getMoviesWithGenreLike/{genreId}")
    public ResponseEntity<MoviesListDTO> getMoviesWithGenreLike(@PathVariable Long genreId) {
        return ResponseEntity.ok(service.getMoviesWithGenreLike(genreId));
    }

    @GetMapping ("/getSeriesWithMoreSeasonsThan/{seasonsQuantity}")
    public ResponseEntity<SeriesListDTO> getSeriesWithMoreSeasonsThan(@PathVariable int seasonsQuantity) {
        return ResponseEntity.ok(service.getSeriesWithMoreSeasonsThan(seasonsQuantity));
    }

    @GetMapping ("/getSeriesEpisodeWithStarredActor/{actorId}")
    public ResponseEntity<EpisodesListDTO> getSeriesEpisodeWithStarredActor(@PathVariable Long actorId) {
        return ResponseEntity.ok(service.getSeriesEpisodeWithStarredActor(actorId));
    }
}
