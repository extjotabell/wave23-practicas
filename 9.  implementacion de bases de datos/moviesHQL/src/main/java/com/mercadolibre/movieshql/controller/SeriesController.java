package com.mercadolibre.movieshql.controller;

import com.mercadolibre.movieshql.model.dtos.SeriesDTO;
import com.mercadolibre.movieshql.services.ISeriesService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeriesController {

    private final ISeriesService seriesService;

    public SeriesController(ISeriesService seriesService) {
        this.seriesService = seriesService;
    }

    /**
     * Controller to list all series that have more than the quantity of seasons received as parameter.
     */

    @GetMapping("/series")
    public ResponseEntity<List<SeriesDTO>> findSeriesHigherThanSeasonsValue(@RequestParam("value") Integer seasons) {
        return ResponseEntity.ok().body(seriesService.findSeriesHigherThanSeasonsValue(seasons));
    }
}
