package com.implementationbd.movie.service.interfaces;

import com.implementationbd.movie.model.dto.ActorDto;
import com.implementationbd.movie.model.entity.Actor;

import java.util.List;

public interface IActorService {
    List<ActorDto> getActorsWorkedIn(Long movieId);
    List<ActorDto> getActorsWithRatingGreaterThan(double rating);

    List<ActorDto> getActorsWithFavoriteMovie();
}
