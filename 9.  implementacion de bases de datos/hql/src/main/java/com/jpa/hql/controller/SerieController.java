package com.jpa.hql.controller;

import com.jpa.hql.model.dto.SerieDTO;
import com.jpa.hql.service.ISerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/series")
public class SerieController {
    @Autowired
    private ISerieService serieService;
    @GetMapping(value = "")
    public ResponseEntity<Set<SerieDTO>> getSeriesWithNumberOfSeasonsGreaterThan(
            @RequestParam(name = "number_seasons_gt") Integer numberSeasons
    )
    {
        return ResponseEntity.ok(serieService.getSeriesWithNumberOfSeasonsGreaterThan(numberSeasons));
    }
}
