package com.implementationbd.movie.controller;

import com.implementationbd.movie.model.dto.MovieDto;
import com.implementationbd.movie.model.entity.Movie;
import com.implementationbd.movie.service.interfaces.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/movie")
public class MovieController {

    @Autowired
    IMovieService service;

    @GetMapping("/with-rating-greater-than/{rating}")
    public ResponseEntity<List<MovieDto>> getMoviesWithRatingActorGreaterThan(@PathVariable double rating) {
        return new ResponseEntity<>(service.getMoviesWithRatingActorGreaterThan(rating), HttpStatus.OK);
    }

    @GetMapping("/by-genre/{genreId}")
    public ResponseEntity<List<MovieDto>> getMoviesByGenreId(@PathVariable Long genreId) {
        return new ResponseEntity<>(service.getMoviesByGenreId(genreId), HttpStatus.OK);
    }
}
