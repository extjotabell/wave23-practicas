package com.example.movies.controller;

import com.example.movies.service.GenericService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GenericController {
    private GenericService service;

    public GenericController(GenericService service) {
        this.service = service;
    }

    //Listar todos los actores que tengan declarada una película favorita.
    @GetMapping("/getActorsWithFavorteMovie")
    public ResponseEntity<?>getActorsWithFavorteMovie(){
        return service.getActorsWithFavorteMovie();
    }

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro
    @GetMapping("/getActorsRatingThant/{rating}")
    public ResponseEntity<?>getActorsRatingThant(@PathVariable Double rating){
        return service.getActorsRatingThant(rating);
    }

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @GetMapping("/getActorsWorkIn/{movieId}")
    public ResponseEntity<?>getActorsWorkIn(@PathVariable Long movieId){
        return service.getActorsWorkIn(movieId);
    }

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/getMoviesWithActorsRating/{rating}")
    public ResponseEntity<?>getMoviesWithActorsRating(@PathVariable Double rating){
        return service.getMoviesWithActorsRating(rating);
    }

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @GetMapping("/getMoviesWithGenreIn/{genreId}")
    public ResponseEntity<?>getMoviesWithGenreIn(@PathVariable Long genreId){
        return service.getMoviesWithGenreIn(genreId);
    }

    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @GetMapping("/getSeriesWithMore/{seasonsQ}")
    public ResponseEntity<?>getSeriesWithMore(@PathVariable int seasonsQ){
        return service.getSeriesWithMore(seasonsQ);
    }

    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @GetMapping("/getEpisodesWithActor/{actorId}")
    public ResponseEntity<?>getEpisodesWithActor(@PathVariable Long actorId){
        return service.getEpisodesWithActor(actorId);
    }
}
