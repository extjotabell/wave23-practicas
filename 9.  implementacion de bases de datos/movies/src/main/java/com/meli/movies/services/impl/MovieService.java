package com.meli.movies.services.impl;

import com.meli.movies.dtos.response.MovieActorsDTO;
import com.meli.movies.mappers.ActorMapper;
import com.meli.movies.mappers.MovieMapper;
import com.meli.movies.repositories.IMovieRepository;
import com.meli.movies.services.IMovieService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService {

    private static IMovieRepository movieRepository;

    public MovieService(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieActorsDTO> getMoviesActors() {
        return movieRepository.findAll().stream()
                .map(MovieMapper::toActorsDTO)
                .toList();
    }

}
