package com.meli.movies.service.actor;

import com.meli.movies.dto.ActorsDTO;

import java.math.BigDecimal;

public interface IActorService {
    ActorsDTO getActorWithFavoriteMovies();

    ActorsDTO findByRatingGreaterThan(BigDecimal rating);
}
