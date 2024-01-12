package com.meli.movies.services.impl;

import com.meli.movies.dtos.response.ActorDTO;
import com.meli.movies.dtos.response.ActorFavoriteMovieDTO;
import com.meli.movies.mappers.ActorMapper;
import com.meli.movies.repositories.IActorRepository;
import com.meli.movies.services.IActorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    private final IActorRepository  actorRepository;

    public ActorService(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorFavoriteMovieDTO> getActorsWithFavoriteMovie() {
        return actorRepository.getActorsWithFavoriteMovie().stream().map(ActorMapper::toFavoriteMovieDTO).toList();
    }

    @Override
    public List<ActorDTO> getActorsFilterByRating(Double rating) {
        return actorRepository.getActorsFilterByRating(rating).stream().map(ActorMapper::toDTO).toList();
    }

    @Override
    public List<ActorDTO> getActorsByMoviesTitle(String title) {
        return actorRepository.getActorsByMoviesTitle(title).stream().map(ActorMapper::toDTO).toList();
    }
}
