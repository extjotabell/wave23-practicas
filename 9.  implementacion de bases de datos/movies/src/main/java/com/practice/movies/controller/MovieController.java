package com.practice.movies.controller;

import com.practice.movies.service.MoviesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MoviesServiceImpl moviesService;

    @GetMapping("/actors/with-fav-movie")
    public ResponseEntity<?> listActorsWithFavMovie(){
        return new ResponseEntity<>(moviesService.listActorsWithFavMovie(), HttpStatus.OK);
    }

    @GetMapping("/actors/rating-over/{rating}")
    public ResponseEntity<?> listActorsWithRatingOver(@PathVariable Double rating){
        return new ResponseEntity<>(moviesService.listActorsWithRatingOver(rating), HttpStatus.OK);
    }

    @GetMapping("/actors/movie/{movie_id}")
    public ResponseEntity<?> listActorsInMovie(@PathVariable Integer movie_id){
        return new ResponseEntity<>(moviesService.listActorsInMovie(movie_id), HttpStatus.OK);
    }

    @GetMapping("/movies/actors-rating-over/{rating}")
    public ResponseEntity<?> listMoviesWithActorsRatingOver(@PathVariable Double rating){
        return new ResponseEntity<>(moviesService.listMoviesWithActorsRatingOver(rating), HttpStatus.OK);
    }

    @GetMapping("/movies/genre/{genre_id}")
    public ResponseEntity<?> listMoviesWithGenreId(@PathVariable Integer genre_id){
        return new ResponseEntity<>(moviesService.listMoviesWithGenreId(genre_id), HttpStatus.OK);
    }

    @GetMapping("/series/seasons-number-over/{number}")
    public ResponseEntity<?> listSeriesWithSeasonsNumberOver(@PathVariable Integer number){
        return new ResponseEntity<>(moviesService.listSeriesWithSeasonsNumberOver(number), HttpStatus.OK);
    }

    @GetMapping("/episodes/actor/{actor_id}")
    public ResponseEntity<?> listEpisodesWithActor(@PathVariable Integer actor_id){
        return new ResponseEntity<>(moviesService.listEpisodesWithActor(actor_id), HttpStatus.OK);
    }
}