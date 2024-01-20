package com.implementationbd.movie.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.implementationbd.movie.model.dto.ActorDto;
import com.implementationbd.movie.repository.IActorRepository;
import com.implementationbd.movie.service.interfaces.IActorService;
import com.implementationbd.movie.util.UtilConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    IActorRepository repository;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public List<ActorDto> getActorsWorkedIn(Long movieId) {
        return repository.getActorsWorkedIn(movieId).stream()
                .map(UtilConvert::toDto)
                .toList();
    }

    @Override
    public List<ActorDto> getActorsWithRatingGreaterThan(double rating) {
        return repository.getActorsWithRatingGreaterThan(rating).stream()
                .map(UtilConvert::toDto)
                .toList();
    }

    @Override
    public List<ActorDto> getActorsWithFavoriteMovie() {
        return repository.getActorsWithFavoriteMovie().stream()
                .map(UtilConvert::toDto)
                .toList();
    }
}
