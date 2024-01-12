package com.example.movieshql.service.actor;

import com.example.movieshql.dto.ActorDto;
import com.example.movieshql.model.Actor;
import com.example.movieshql.repository.ActorRepository;
import com.example.movieshql.repository.MovieRepository;
import com.example.movieshql.service.actor.ActorService;
import com.example.movieshql.utils.DTOMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    private final MovieRepository movieRepository;

    public ActorServiceImpl(ActorRepository actorRepository, MovieRepository movieRepository) {
        this.actorRepository = actorRepository;
        this.movieRepository = movieRepository;
    }

    @Override
    @Transactional
    public List<ActorDto> findActorsWithFavoriteMovie() {
        return actorRepository.findActorsWithFavoriteMovie().stream().map(DTOMapper::mapToActorDTO).toList();
    }

    @Override
    @Transactional
    public List<ActorDto> findActorsWithRatingHigherThan(Double rating) {
        return actorRepository.findActorsWithRatingHigherThan(rating).stream().map(DTOMapper::mapToActorDTO).toList();
    }

    @Override
    @Transactional
    public List<ActorDto> findActorsByFavoriteMovie(Long movieId) {
        return actorRepository.findActorsByFavoriteMovie(
                movieRepository.findById(movieId).orElseThrow()).stream().map(DTOMapper::mapToActorDTO).toList();
    }
}
