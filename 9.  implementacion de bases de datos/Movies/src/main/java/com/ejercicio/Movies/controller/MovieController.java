package com.ejercicio.Movies.controller;

import com.ejercicio.Movies.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieServiceImpl movieService;

    /**
     * Handles the GET request to retrieve a list of movies whose actors have a rating greater than a specified value.
     * This operation is useful for filtering movies based on the performance rating of their actors and retrieving
     * those whose actors have achieved a performance above a certain threshold.
     *
     * @param rating The rating value used as the minimum threshold for filtering movies.
     *               Only movies whose actors have a rating higher than this value will be included in the response.
     * @return A ResponseEntity containing the list of movies whose actors have a rating greater than the specified
     *         value and the HTTP status code. The response body includes movies meeting the criteria,
     *         or an empty list if no movies have actors with a rating above the given threshold.
     */
    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> getMovieWithActorsWithRatingGreaterThan(@PathVariable double rating) {
        return new ResponseEntity<>(movieService.findMoviesWithActorsWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    /**
     * Handles the GET request to retrieve a list of movies whose genre matches the specified value.
     * This operation is useful for filtering movies based on their genre and retrieving those that match a given genre.
     *
     * @param genre The genre value used for filtering movies.
     *              Only movies whose genre matches this value will be included in the response.
     * @return A ResponseEntity containing the list of movies whose genre matches the specified value and the HTTP
     *         status code. The response body includes movies meeting the criteria, or an empty list if no movies
     *         match the given genre.
     */
    @GetMapping("/genre/{genre}")
    public ResponseEntity<?> getMovieByGenre(@PathVariable String genre) {
        return new ResponseEntity<>(movieService.findMoviesByGenre(genre), HttpStatus.OK);
    }
}
