package com.ejercicio.Movies.service.Interface;

import com.ejercicio.Movies.dto.ActorDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> findActorsWithFavoriteMovie();
    List<ActorDTO> findActorsWithRatingGreaterThan(double rating);
    List<ActorDTO> findActorsByMovie(String movie);
}
