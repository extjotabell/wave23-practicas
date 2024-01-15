package com.mercadolibre.movieshql.services.impl;

import com.mercadolibre.movieshql.model.dtos.ActorsDTO;
import com.mercadolibre.movieshql.repositories.IActorRepository;
import com.mercadolibre.movieshql.services.IActorsService;
import com.mercadolibre.movieshql.utils.MapperDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ActorsServiceImpl implements IActorsService {

    private final IActorRepository actorRepository;

    public ActorsServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    @Transactional
    public List<ActorsDTO> findActorsWithOneFavoriteMovie() {
        return actorRepository.findActorsWithOneFavoriteMovie().stream().map(MapperDTO::mapActorsDTO).toList();
    }

    @Override
    @Transactional
    public List<ActorsDTO> findActorsWithRatingHigherThanValue(BigDecimal rating) {
        return actorRepository.findActorsWithRatingHigherThan(rating).stream().map(MapperDTO::mapActorsDTO).toList();
    }

    @Override
    public List<ActorsDTO> findActorsByMovieTitle(String movieTitle) {
        return actorRepository.findActorsByMovie(movieTitle).stream().map(MapperDTO::mapActorsDTO).toList();
    }
}
