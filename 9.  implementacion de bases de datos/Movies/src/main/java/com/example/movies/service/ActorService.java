package com.example.movies.service;

import com.example.movies.dto.ActorFavoriteMovieDTO;
import com.example.movies.dto.ActorSimpleDTO;
import com.example.movies.repository.ActorRepository;
import com.example.movies.utils.Mapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

  private final ActorRepository actorRepository;

  public ActorService(ActorRepository actorRepository) {
    this.actorRepository = actorRepository;
  }

  public List<ActorFavoriteMovieDTO> getActorsWithFavoriteMovie() {
    return actorRepository.findAllWithFavoriteMovie().stream()
        .map(Mapper::actorToActorFavoriteMovieDTO).collect(Collectors.toList());
  }

  public List<ActorSimpleDTO> getActorsWithRatingHigher(BigDecimal rating) {
    return actorRepository.findAllWithRatingHigher(rating).stream()
        .map(Mapper::actorToActorSimpleDTO).collect(Collectors.toList());
  }

  public List<ActorSimpleDTO> getActorsActedInMovie(String movie) {
    return actorRepository.findAllActedInMovie(movie).stream().map(Mapper::actorToActorSimpleDTO).collect(
        Collectors.toList());
  }
}
