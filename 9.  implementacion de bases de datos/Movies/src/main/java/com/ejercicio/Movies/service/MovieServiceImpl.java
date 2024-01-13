package com.ejercicio.Movies.service;

import com.ejercicio.Movies.dto.MovieDTO;
import com.ejercicio.Movies.model.Movie;
import com.ejercicio.Movies.repository.IMovieRepository;
import com.ejercicio.Movies.service.Interface.IMovieService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {
    private IMovieRepository movieRepository;

    public MovieServiceImpl(IMovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<MovieDTO> findMoviesWithActorsWithRatingGreaterThan(double rating) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Movie> movies = movieRepository.findMoviesWithActorsWithRatingGreaterThan(rating);

        return movies.stream()
                .map(movie -> mapper.convertValue(movie, MovieDTO.class))
                .toList();
    }

    @Override
    public List<MovieDTO> findMoviesByGenre(String genre) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        List<Movie> movies = movieRepository.findMoviesByGenre(genre);

        return movies.stream()
                .map(movie -> mapper.convertValue(movie, MovieDTO.class))
                .toList();
    }
}