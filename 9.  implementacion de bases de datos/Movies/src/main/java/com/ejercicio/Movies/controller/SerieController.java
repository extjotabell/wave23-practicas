package com.ejercicio.Movies.controller;

import com.ejercicio.Movies.service.SerieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private SerieServiceImpl serieService;

    /**
     * Handles the GET request to retrieve a list of series that have more than a certain number of seasons,
     * where the number of seasons is greater than the specified rating. This endpoint is particularly useful
     * for identifying series with a significant number of seasons, indicating potentially popular or long-running series.
     * It helps users find series that have extended beyond the typical number of seasons, based on the given rating threshold.
     *
     * @param rating The minimum number of seasons a series must have to be included in the response. This parameter
     *               is extracted from the URL path.
     * @return A ResponseEntity containing the list of series with more than the specified number of seasons
     *         and the HTTP status code. The response body includes series meeting the criteria,
     *         or an empty list if no series have more than the given number of seasons.
     */
    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> getSerieWithSeasonsWithRatingGreaterThan(@PathVariable int rating) {
        return new ResponseEntity<>(serieService.findSeriesWithMoreThanNumberOfSeasons(rating), HttpStatus.OK);
    }


}
