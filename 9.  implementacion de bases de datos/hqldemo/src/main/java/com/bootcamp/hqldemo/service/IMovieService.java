package com.bootcamp.hqldemo.service;

import com.bootcamp.hqldemo.model.entity.Actor;
import com.bootcamp.hqldemo.model.entity.Episode;
import com.bootcamp.hqldemo.model.entity.Movie;
import com.bootcamp.hqldemo.model.entity.Serie;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMovieService {

    List<Actor> getAllActorsWithFavouriteMovies();

    List<Actor> getAllActorsRating(Double rating);

    List<Actor> getAllActorsFromMovie(String movie);

    List<Movie> getAllMoviesWithActorsRating(Double rating);

    List<Movie> getAllMoviesByGenre(String genre);

    List<Serie> getAllSeriesWithAmountOfSeasons(Integer seasons);

    List<Episode> getEpisodeFromActor(String actor);

}
