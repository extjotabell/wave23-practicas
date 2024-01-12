package com.mercadolibre.hql.controller;

import com.mercadolibre.hql.dto.SerieDTO;
import com.mercadolibre.hql.service.ISerieService;
import com.mercadolibre.hql.service.SerieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SerieController {

    ISerieService serieService;
    public SerieController(ISerieService serieService) {
        this.serieService = serieService;
    }

    @GetMapping("/seasons/count/{number}")
    public ResponseEntity<List<SerieDTO>> findAllByMinimumNumberOfSeasons(@PathVariable Integer number) {
        return new ResponseEntity<>(serieService.findAllByMinimumNumberOfSeasons(number), HttpStatus.OK);
    }
}
