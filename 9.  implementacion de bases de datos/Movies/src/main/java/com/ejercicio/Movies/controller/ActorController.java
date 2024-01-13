package com.ejercicio.Movies.controller;

import com.ejercicio.Movies.service.ActorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private ActorServiceImpl actorService;

    /**
     * Handles the GET request to retrieve a list of actors who have a favorite movie set in their profile.
     * This endpoint is particularly useful for identifying actors with specific movie preferences or to understand
     * patterns in favorite movie choices among actors. It helps in gathering insights about actors' choices
     * and preferences in the film industry.
     *
     * @return A ResponseEntity containing the list of actors who have a favorite movie and the HTTP status code.
     *         The response body includes actors with a favorite movie set in their profile.
     *         If no actors have a favorite movie set, an empty list is returned.
     */
    @GetMapping("/favorite-movie")
    public ResponseEntity<?> getActorWithFavoriteMovie() {
        return new ResponseEntity<>(actorService.findActorsWithFavoriteMovie(), HttpStatus.OK);
    }

    /**
     * Handles the GET request to retrieve a list of actors whose rating is greater than a specified value.
     * This operation is useful for filtering actors based on their performance rating and retrieving those
     * who have achieved a performance above a certain threshold.
     *
     * @param rating The rating value used as the minimum threshold for filtering actors.
     *               Only actors with a rating higher than this value will be included in the response.
     * @return A ResponseEntity containing the list of actors with a rating greater than the specified value
     *         and the HTTP status code. The response body includes actors meeting the criteria,
     *         or an empty list if no actors have a rating above the given threshold.
     */
    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> getActorWithRatingGreaterThan(@PathVariable double rating) {
        return new ResponseEntity<>(actorService.findActorsWithRatingGreaterThan(rating), HttpStatus.OK);
    }

    /**
     * Handles the GET request to retrieve a list of actors who have acted in a specified movie.
     * This operation is useful for identifying actors who have acted in a particular movie.
     *
     * @param movie The movie name used to filter actors.
     *              Only actors who have acted in this movie will be included in the response.
     * @return A ResponseEntity containing the list of actors who have acted in the specified movie
     *         and the HTTP status code. The response body includes actors meeting the criteria,
     *         or an empty list if no actors have acted in the given movie.
     */
    @GetMapping("/movie/{movie}")
    public ResponseEntity<?> getActorByMovie(@PathVariable String movie) {
        return new ResponseEntity<>(actorService.findActorsByMovie(movie), HttpStatus.OK);
    }
}
