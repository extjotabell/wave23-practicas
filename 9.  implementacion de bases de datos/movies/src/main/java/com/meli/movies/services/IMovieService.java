package com.meli.movies.services;

import com.meli.movies.dtos.response.MovieActorsDTO;

import java.util.List;

public interface IMovieService {
    List<MovieActorsDTO> getMoviesActors();

    List<MovieActorsDTO> getMoviesActorsByRating(Double rating);
}
