package com.example.movies.controller;

import com.example.movies.dto.MovieSimpleDTO;
import com.example.movies.dto.SerieNumberSeasonDTO;
import com.example.movies.models.Serie;
import com.example.movies.service.MovieService;
import com.example.movies.service.SerieService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/series")
public class SerieController {

  private final SerieService serieService;

  public SerieController(SerieService serieService) {
    this.serieService = serieService;
  }

  @GetMapping("/seasons/number/greater/{numberSeasons}")
  public ResponseEntity<List<SerieNumberSeasonDTO>> getSeriesWithNumberSeasonsGreater(@PathVariable Integer numberSeasons){
    return ResponseEntity.ok(serieService.getSeriesWithNumberSeasonsGreater(numberSeasons));
  }

  @GetMapping
  public List<Serie> getSeries(){
    return serieService.getSeries();
  }

}
