package com.meli.movies.services;

import com.meli.movies.dtos.response.ActorDTO;

import java.util.List;

public interface IActorService {
    List<ActorDTO> getActorsWithFavoriteMovie();
}