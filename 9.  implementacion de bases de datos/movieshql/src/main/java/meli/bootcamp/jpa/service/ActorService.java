package meli.bootcamp.jpa.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import meli.bootcamp.jpa.model.dto.ActorInfoDto;
import meli.bootcamp.jpa.repository.ActorRepository;
import meli.bootcamp.jpa.util.Mapper;

@Service
public class ActorService {
  private final ActorRepository repository;

  public ActorService(ActorRepository repository) {
    this.repository = repository;
  }

  public List<ActorInfoDto> getAllWithFavouriteMovie() {
    return this.repository.findWithFavouriteMovie().stream().map(a -> Mapper.map(a)).toList();
  }

  public List<ActorInfoDto> getByRatingGreaterThan(BigDecimal rating) {
    return this.repository.findByRatingGreaterThan(rating).stream().map(a -> Mapper.map(a)).toList();
  }

  public List<ActorInfoDto> getByWorkingMovieTitle(String title) {
    return this.repository.findByWorkingMovieTitle(title).stream().map(a -> Mapper.map(a)).toList();
  }
}
