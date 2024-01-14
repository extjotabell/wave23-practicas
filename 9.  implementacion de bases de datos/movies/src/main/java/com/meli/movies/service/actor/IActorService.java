package com.meli.movies.service.actor;

import com.meli.movies.dto.ActorsDTO;

import java.math.BigDecimal;

public interface IActorService {
    ActorsDTO findByFavoriteMovieNotNull();

    ActorsDTO findByRatingGreaterThan(BigDecimal rating);
}
