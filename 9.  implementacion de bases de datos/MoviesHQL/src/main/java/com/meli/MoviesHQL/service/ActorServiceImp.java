package com.meli.MoviesHQL.service;

import com.meli.MoviesHQL.dto.ActorDto;
import com.meli.MoviesHQL.exception.NotFoundException;
import com.meli.MoviesHQL.model.Actor;
import com.meli.MoviesHQL.repository.ActorRepository;
import com.meli.MoviesHQL.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImp implements ActorService {

    ActorRepository actorRepository;
    MovieRepository movieRepository;

    public ActorServiceImp(ActorRepository repository, MovieRepository movieRepository) {
        this.actorRepository = repository;
        this.movieRepository = movieRepository;
    }

    @Override
    public List<ActorDto> findByFavoriteMovieIsNotNull() {
        List<Actor> actors = actorRepository.findByFavoriteMovieIsNotNull();
        return actors.stream().map(ActorDto::new).toList();
    }

    @Override
    public List<ActorDto> findByRatingIsGreaterThanEqual(Double rating) {
        List<Actor> actors = actorRepository.findByRatingIsGreaterThanEqual(rating);
        return actors.stream().map(ActorDto::new).toList();
    }

    @Override
    public List<ActorDto> findByMovie(Long movieId) {
        // Check if movie exists
        movieRepository.findById(movieId).orElseThrow(() -> new NotFoundException("Movie not found"));

        List<Actor> actors = actorRepository.findByMovie(movieId);
        return actors.stream().map(ActorDto::new).toList();
    }

}
