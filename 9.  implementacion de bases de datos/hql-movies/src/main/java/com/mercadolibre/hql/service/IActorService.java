package com.mercadolibre.hql.service;

import com.mercadolibre.hql.dto.ActorDTO;

import java.util.List;

public interface IActorService {

    List<ActorDTO> findAllByFavoriteMovieIsNotNull();
    List<ActorDTO> findAllByRatingGreaterThan(Double rating);
    List<ActorDTO> findAllByActorMovie(String title);
}
