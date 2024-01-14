package com.meli.movies.service.movie;

import com.meli.movies.dto.MovieDTO;
import com.meli.movies.dto.MoviesDTO;
import com.meli.movies.repository.IMovieRepository;
import com.meli.movies.util.MovieMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    IMovieRepository repository;

    public MovieServiceImpl(IMovieRepository repository) { this.repository = repository; }

    @Override
    public MoviesDTO findByActorRatingGreaterThan(BigDecimal rating) {
        List<MovieDTO> movies = repository.findByActorRatingGreaterThan(rating).stream()
                .map(MovieMapper::map)
                .toList();

        return new MoviesDTO(movies);
    }

    @Override
    public MoviesDTO findByGenre(String genre) {
        List<MovieDTO> movies = repository.findByGenre(genre).stream()
                .map(MovieMapper::map)
                .toList();

        return new MoviesDTO(movies);
    }
}
