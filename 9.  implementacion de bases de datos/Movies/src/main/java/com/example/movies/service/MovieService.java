package com.example.movies.service;

import com.example.movies.dto.MovieSimpleDTO;
import com.example.movies.repository.MovieRepository;
import com.example.movies.utils.Mapper;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

  private final MovieRepository movieRepository;

  public MovieService(MovieRepository movieRepository) {
    this.movieRepository = movieRepository;
  }

  public List<MovieSimpleDTO> getMoviesWithRatingHigher(BigDecimal rating) {
    return movieRepository.findAllWithRatingHigher(rating).stream()
        .map(Mapper::movieToMovieSimpleDTO).collect(Collectors.toList());
  }

  public List<MovieSimpleDTO> getMoviesOfGenre(String genre) {
    return movieRepository.getMoviesOfGenre(genre).stream().map(Mapper::movieToMovieSimpleDTO)
        .collect(Collectors.toList());
  }


}
