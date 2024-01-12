package com.meli.movies.services;

import com.meli.movies.dtos.response.ActorDTO;
import com.meli.movies.dtos.response.ActorFavoriteMovieDTO;

import java.util.List;

public interface IActorService {
    List<ActorFavoriteMovieDTO> getActorsWithFavoriteMovie();
    List<ActorDTO> getActorsFilterByRating(Double rating);
    List<ActorDTO> getActorsByMoviesTitle(String title);
}