package com.example.ejercicioHQL.controller;

import com.example.ejercicioHQL.service.ISeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    ISeriesService seriesService;

    @GetMapping("/seasons/number/{n}")
    public ResponseEntity<?> findBySeasonsNumber(@PathVariable Integer n){
        return ResponseEntity.ok(seriesService.findBySeasonsCount(n));
    }

}
