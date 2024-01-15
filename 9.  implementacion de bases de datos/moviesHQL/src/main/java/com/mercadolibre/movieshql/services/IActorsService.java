package com.mercadolibre.movieshql.services;

import com.mercadolibre.movieshql.model.dtos.ActorsDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IActorsService {

    List<ActorsDTO> findActorsWithOneFavoriteMovie();
    List<ActorsDTO> findActorsWithRatingHigherThanValue(BigDecimal rating);
    List<ActorsDTO> findActorsByMovieTitle(String movieTitle);
}
