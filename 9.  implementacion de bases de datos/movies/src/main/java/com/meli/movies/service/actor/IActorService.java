package com.meli.movies.service.actor;

import com.meli.movies.dto.ActorsDTO;

public interface IActorService {
    ActorsDTO getActorWithFavoriteMovies();
}
