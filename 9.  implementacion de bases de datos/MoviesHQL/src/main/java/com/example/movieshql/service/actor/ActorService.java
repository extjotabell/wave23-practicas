package com.example.movieshql.service.actor;

import com.example.movieshql.dto.ActorDto;
import com.example.movieshql.model.Actor;

import java.util.List;

public interface ActorService {

    List<ActorDto> findActorsWithFavoriteMovie();

    List<ActorDto> findActorsWithRatingHigherThan(Double rating);

    List<ActorDto> findActorsByFavoriteMovie(Long movieId);
}
