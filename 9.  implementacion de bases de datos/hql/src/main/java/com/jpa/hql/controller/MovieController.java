package com.jpa.hql.controller;

import com.jpa.hql.model.dto.MovieDTO;
import com.jpa.hql.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Set;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private IMovieService movieService;
    @GetMapping(value = "", params = {"actors_rating_gt", "!genre"})
    public ResponseEntity<Set<MovieDTO>> getAllMoviesWithActorsWithRatingGreaterThan(
            @RequestParam(name = "actors_rating_gt")BigDecimal rating
            )
    {
        return ResponseEntity.ok(movieService.getAllMoviesWithActorsWithRatingGreaterThan(rating));
    }

    @GetMapping(value = "", params = {"!actors_rating_gt", "genre"})
    public ResponseEntity<Set<MovieDTO>> getAllMoviesByGenre(
            @RequestParam(name = "genre")String genre
    )
    {
        return ResponseEntity.ok(movieService.getAllMoviesByGenre(genre));
    }
}
