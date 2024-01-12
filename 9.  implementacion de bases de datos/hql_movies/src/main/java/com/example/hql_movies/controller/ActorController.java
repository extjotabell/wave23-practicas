package com.example.hql_movies.controller;

import com.example.hql_movies.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
    @Autowired
    ActorService service;

    @GetMapping("/list")
    public ResponseEntity<?> obtenerActores(){
        return ResponseEntity.ok(service.obtenerActores());
    }

    @GetMapping("/list/firstName")
    public ResponseEntity<?> obtenerFirstName(){
        return ResponseEntity.ok(service.findFirstName());
    }

    @GetMapping("/list/actorsWithFavoriteMovie")
    public ResponseEntity<?> obtenerActoresConPelicula(){
        return ResponseEntity.ok(service.findActorWithFavoriteMovie());
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<?> obtenerRaiting(@PathVariable Double rating){
        return ResponseEntity.ok(service.findActorRaiting(rating));
    }

    @GetMapping("/movie/{title}")
    public ResponseEntity<?> obtenerMovie(@PathVariable String title){
        return ResponseEntity.ok(service.findMovie(title));
    }

    @GetMapping("/movie/rating/{rating}")
    public ResponseEntity<?> obtenerMovieActorRating(@PathVariable Double rating){
        return ResponseEntity.ok(service.findMovieActorRating(rating));
    }

    @GetMapping("/movie/genre/{genre}")
    public ResponseEntity<?> obtenerMovieGender(@PathVariable String genre){
        return ResponseEntity.ok(service.findMovieGender(genre));
    }

    @GetMapping("/movies")
    public ResponseEntity<?> obtenerTodasLasPeliculas(){
        return ResponseEntity.ok(service.findAllMovie());
    }

    @GetMapping("/serie/{number}")
    public ResponseEntity<?> obtenerSerieRating(@PathVariable Integer number){
        return ResponseEntity.ok(service.findSerieNumber(number));
    }

    @GetMapping("/season")
    public ResponseEntity<?> obtenerSeason(){
        return ResponseEntity.ok(service.findAllSeason());
    }

    @GetMapping("/episodes")
    public ResponseEntity<?> obtenerEpisodes(){
        return ResponseEntity.ok(service.findEpisodes());
    }

    @GetMapping("/episode/actor/{actor}")
    public ResponseEntity<?> obtenerEpisodioActor(@PathVariable String actor){
        return ResponseEntity.ok(service.findActorEpisode(actor));
    }

}
