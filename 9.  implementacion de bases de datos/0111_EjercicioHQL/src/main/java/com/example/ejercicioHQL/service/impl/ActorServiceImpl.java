package com.example.ejercicioHQL.service.impl;

import com.example.ejercicioHQL.dto.ActorDto;
import com.example.ejercicioHQL.dto.response.ActorAndFavoriteMovieDto;
import com.example.ejercicioHQL.mappers.ActorMapper;
import com.example.ejercicioHQL.model.Actor;
import com.example.ejercicioHQL.repository.ActorRepository;
import com.example.ejercicioHQL.service.IActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements IActorService {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<ActorAndFavoriteMovieDto> findByHasFavoriteMovie() {

        ActorMapper actorMapper = new ActorMapper();

        return actorRepository.findFavoriteMovieNotNull()
                .stream()
                .map(actorMapper::mapActorAndFavoriteMovieDto)
                .toList();
    }

    @Override
    public List<ActorDto> findByRating(Double rating) {
        ActorMapper actorMapper = new ActorMapper();
        return actorRepository.findAllByRating(rating)
                .stream()
                .map(actorMapper::mapActorDto)
                .toList();
    }
}
