package com.mercadolibre.hql.controller;

import com.mercadolibre.hql.dto.MovieDTO;
import com.mercadolibre.hql.service.IMovieService;
import com.mercadolibre.hql.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    IMovieService movieService;
    public MovieController(IMovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/actors/rating/greater/{rating}")
    public ResponseEntity<List<MovieDTO>> findAllByActorsRatingGreaterThan(@PathVariable Double rating) {
        return new ResponseEntity<>(movieService.findAllByActorsRatingGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<MovieDTO>> findAllByGenreName(@PathVariable String genre) {
        return new ResponseEntity<>(movieService.findAllByGenreName(genre), HttpStatus.OK);
    }

}
