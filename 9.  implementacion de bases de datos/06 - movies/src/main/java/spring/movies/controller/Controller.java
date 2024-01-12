package spring.movies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.movies.service.IMoviesService;

@RestController
@RequestMapping("/movies")
public class Controller {

    @Autowired
    private IMoviesService service;


    //Listar todos los actores que tengan declarada una película favorita.
    @GetMapping("/actors-favorite-movies")
    public ResponseEntity<?> getActorsWFavMovies(){
        return new ResponseEntity<>(service.getActorsWFavMovies(), HttpStatus.OK);
    }

    @GetMapping("/actors-favorite-movies/count")
    public ResponseEntity<?> getActorsWFavMoviesCount(){
        return new ResponseEntity<>(service.getActorsWFavMoviesCount(), HttpStatus.OK);
    }

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/actors/rating/{actorRating}")
    public ResponseEntity<?> getActorsByRating(@PathVariable Double actorRating){
        return new ResponseEntity<>(service.getActorsByRating(actorRating), HttpStatus.OK);
    }

    //Listar todos los actores que trabajan en la <película recibida por parámetro>
    @GetMapping("/actors/movie/{movieId}")
    public ResponseEntity<?> getActorsThatWorkIn(@PathVariable Long movieId){
        return new ResponseEntity<>(service.getActorsThatWorkIn(movieId), HttpStatus.OK);
    }

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    @GetMapping("/movies/actorRating/{ratingActor}")
    public ResponseEntity<?> getMoviesActorRating(@PathVariable Double ratingActor){
        return new ResponseEntity<>(service.getMoviesActorRating(ratingActor), HttpStatus.OK);
    }

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    @GetMapping("/movies/genreId/{genreId}")
    public ResponseEntity<?> getMoviesByGenre(@PathVariable Long genreId){
        return new ResponseEntity<>(service.getMoviesByGenre(genreId), HttpStatus.OK);
    }

    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    @GetMapping("/series/seasons/{seasons}")
    public ResponseEntity<?> getByNumeroTemporadasGreaterThan(@PathVariable Integer seasons){
        return new ResponseEntity<>(service.getByNumeroTemporadasGreaterThan(seasons), HttpStatus.OK);
    }

    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    @GetMapping("/episodes/actorName/{actorName}")
    public ResponseEntity<?> getEpisodesByActorName(@PathVariable String actorName){
        return new ResponseEntity<>(service.getEpisodesByActorName(actorName), HttpStatus.OK);
    }

    @GetMapping("/episodes/actorId/{actorId}")
    public ResponseEntity<?> getEpisodesByActorId(@PathVariable Long actorId){
        return new ResponseEntity<>(service.getEpisodesByActorId(actorId), HttpStatus.OK);
    }
}
