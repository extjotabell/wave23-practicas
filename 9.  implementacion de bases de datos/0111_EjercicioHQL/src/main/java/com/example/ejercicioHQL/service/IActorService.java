package com.example.ejercicioHQL.service;

import com.example.ejercicioHQL.dto.ActorDto;
import com.example.ejercicioHQL.dto.response.ActorAndFavoriteMovieDto;
import com.example.ejercicioHQL.model.Actor;

import java.util.List;

public interface IActorService {

    public List<ActorAndFavoriteMovieDto> findByHasFavoriteMovie();
    public List<ActorDto> findByRating(Double rating);

}
