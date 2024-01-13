package com.jpa.hql.service;

import com.jpa.hql.model.dto.ActorDTO;

import java.math.BigDecimal;
import java.util.Set;

public interface IActorService {

    Set<ActorDTO> getAllActorsWithFavoriteMovie();

    Set<ActorDTO> getAllActorsWithRatingGraterThan(BigDecimal rating);

    Set<ActorDTO> getAllActorsWhoParticipatedInMovie(String movieName);

}
