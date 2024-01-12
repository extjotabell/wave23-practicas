package com.meli.movies.services;

import com.meli.movies.dtos.response.MovieActorsDTO;
import com.meli.movies.dtos.response.MovieDTO;

import java.util.List;

public interface IMovieService {
    List<MovieActorsDTO> getMoviesActors();
    List<MovieActorsDTO> getMoviesActorsByRating(Double rating);
    List<MovieDTO> getMoviesByGenre(String genre);
    List<MovieDTO> getBestMovies(Integer year);
}
