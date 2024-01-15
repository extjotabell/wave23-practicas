package com.bootcamp.hqldemo.controller;

import com.bootcamp.hqldemo.model.entity.Actor;
import com.bootcamp.hqldemo.model.entity.Episode;
import com.bootcamp.hqldemo.model.entity.Movie;
import com.bootcamp.hqldemo.model.entity.Serie;
import com.bootcamp.hqldemo.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    IMovieService service;

    @GetMapping("/getactorfavmovies")
    public List<Actor> getAllActorsWithFavouriteMovies(){
        return service.getAllActorsWithFavouriteMovies();
    }

    @GetMapping("/getactorsrating/{rating}")
    public List<Actor> getAllActorsRating(@PathVariable Double rating){
        return service.getAllActorsRating(rating);
    }

    @GetMapping("/getactorsmovies/{movie}")
    public List<Actor> getAllActorsFromMovie(@PathVariable String movie){
        return service.getAllActorsFromMovie(movie);
    }

    @GetMapping("/getmoviesactorsrating/{rating}")
    public List<Movie> getAllMoviesWithActorsRating(@PathVariable Double rating){
        return service.getAllMoviesWithActorsRating(rating);
    }

    @GetMapping("/getmoviesgenre/{genre}")
    public List<Movie> getAllMoviesByGenre(@PathVariable String genre){
        return service.getAllMoviesByGenre(genre);
    }

    @GetMapping("/gerseriesseasons/{seasons}")
    public List<Serie> getAllSeriesWithAmountOfSeasons(@PathVariable Integer seasons){
        return service.getAllSeriesWithAmountOfSeasons(seasons);
    }

    @GetMapping("/getepisodeactor/{actor}")
    public List<Episode> getEpisodeFromActor(@PathVariable String actor){
        return service.getEpisodeFromActor(actor);
    }

}
