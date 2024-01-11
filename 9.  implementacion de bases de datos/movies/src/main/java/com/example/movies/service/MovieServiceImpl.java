package com.example.movies.service;

import com.example.movies.dto.ActorDto;
import com.example.movies.dto.ActorsListDto;
import com.example.movies.model.Actor;
import com.example.movies.repository.MovieRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository repository;
    ObjectMapper mapper = new ObjectMapper();

    public MovieServiceImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActorsListDto findActorsWithFavoriteMovie() {
        List<Actor> actors =repository.findActorsByFavoriteMovieNotNull();
        List<ActorDto> actorsList = actors.stream()
                .map(actor -> mapper.convertValue(actor, ActorDto.class))
                .toList();
        return new ActorsListDto(actorsList);
    }
}
