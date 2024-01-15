package com.example.ejercicioHQL.controller;

import com.example.ejercicioHQL.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    IMovieService movieService;

    @GetMapping("/{titleName}/actor")
    public ResponseEntity<?> findActors(@PathVariable String titleName){
        return ResponseEntity.ok(movieService.findActorsByMovieName(titleName));
    }

    @GetMapping("/actor/{rating}")
    public ResponseEntity<?> findByActorsRating(@PathVariable Double rating){
        return ResponseEntity.ok(movieService.findByActorsRating(rating));
    }

    @GetMapping("/genre/{genreName}")
    public ResponseEntity<?> findByGenreName(@PathVariable String genreName){
        return ResponseEntity.ok(movieService.findByGenreName(genreName));
    }

}
