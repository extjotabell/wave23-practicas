package com.mercadolibre.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.hql.dto.ActorDTO;
import com.mercadolibre.hql.dto.MovieDTO;
import com.mercadolibre.hql.repository.ActorRepository;
import com.mercadolibre.hql.utils.ActorMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    ActorRepository actorRepository;
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDTO> findAllByFavoriteMovieIsNotNull() {
        return actorRepository.findAllByFavoriteMovieIsNotNull().stream()
                .map(ActorMapper::actorMap)
                .toList();
    }

    @Override
    public List<ActorDTO> findAllByRatingGreaterThan(Double rating) {
        return actorRepository.findAllByRatingGreaterThan(rating).stream()
                .map(ActorMapper::actorMap)
                .toList();
    }

    @Override
    public List<ActorDTO> findAllByActorMovie(String title) {
        return actorRepository.findAllByActorMovie(title).stream()
                .map(ActorMapper::actorMap)
                .toList();
    }
}
