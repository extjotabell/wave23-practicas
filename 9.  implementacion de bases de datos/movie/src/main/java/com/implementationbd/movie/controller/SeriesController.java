package com.implementationbd.movie.controller;

import com.implementationbd.movie.model.dto.SeriesDto;
import com.implementationbd.movie.service.interfaces.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/serie")
public class SeriesController {

    @Autowired
    ISeriesService repository;

    @GetMapping("/with-more-than-seasons/{seasonCount}")
    public ResponseEntity<List<SeriesDto>> getSeriesWithMoreThanSeasons(@PathVariable int seasonCount) {
        return new ResponseEntity<>(repository.getSeriesWithMoreThanSeasons(seasonCount), HttpStatus.OK);
    }

}
