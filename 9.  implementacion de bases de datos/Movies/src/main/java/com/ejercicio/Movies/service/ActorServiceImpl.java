package com.ejercicio.Movies.service;

import com.ejercicio.Movies.dto.ActorDTO;
import com.ejercicio.Movies.model.Actor;
import com.ejercicio.Movies.repository.IActorRepository;
import com.ejercicio.Movies.service.Interface.IActorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActorServiceImpl implements IActorService {
    private IActorRepository actorRepository;

    public ActorServiceImpl(IActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public List<ActorDTO> findActorsWithFavoriteMovie() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Actor> actors = actorRepository.findActorsWithFavoriteMovie();

        return actors.stream()
                .map(actor -> mapper.convertValue(actor, ActorDTO.class))
                .toList();
    }

    @Override
    public List<ActorDTO> findActorsWithRatingGreaterThan(double rating) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Actor> actors = actorRepository.findActorsWithRatingGreaterThan(rating);

        return actors.stream()
                .map(actor -> mapper.convertValue(actor, ActorDTO.class))
                .toList();
    }

    @Override
    public List<ActorDTO> findActorsByMovie(String movie) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Actor> actors = actorRepository.findActorsByMovie(movie);

        return actors.stream()
                .map(actor -> mapper.convertValue(actor, ActorDTO.class))
                .toList();
    }
}
