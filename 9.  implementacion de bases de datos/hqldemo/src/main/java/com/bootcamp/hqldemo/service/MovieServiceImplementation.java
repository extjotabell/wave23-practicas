package com.bootcamp.hqldemo.service;

import com.bootcamp.hqldemo.model.entity.Actor;
import com.bootcamp.hqldemo.model.entity.Episode;
import com.bootcamp.hqldemo.model.entity.Movie;
import com.bootcamp.hqldemo.model.entity.Serie;
import com.bootcamp.hqldemo.repository.IMoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImplementation implements IMovieService{

    @Autowired
    IMoviesRepository repository;

    @Override
    public List<Actor> getAllActorsWithFavouriteMovies() {
        return repository.getAllActorsWithFavouriteMovies();
    }

    @Override
    public List<Actor> getAllActorsRating(Double rating) {
        return repository.getAllActorsRating(rating);
    }

    @Override
    public List<Actor> getAllActorsFromMovie(String movie) {
        return repository.getAllActorsFromMovie(movie);
    }

    @Override
    public List<Movie> getAllMoviesWithActorsRating(Double rating) {
        return repository.getAllMoviesWithActorsRating(rating);
    }

    @Override
    public List<Movie> getAllMoviesByGenre(String genre) {
        return repository.getAllMoviesByGenre(genre);
    }

    @Override
    public List<Serie> getAllSeriesWithAmountOfSeasons(Integer seasons) {
        return repository.getAllSeriesWithAmountOfSeasons(seasons);
    }

    @Override
    public List<Episode> getEpisodeFromActor(String actor) {
        return repository.getEpisodeFromActor(actor);
    }
}
