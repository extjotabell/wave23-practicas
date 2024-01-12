package com.mercadolibre.hql.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mercadolibre.hql.dto.MovieDTO;
import com.mercadolibre.hql.repository.MovieRepository;
import com.mercadolibre.hql.utils.MovieMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService implements IMovieService {

    MovieRepository movieRepository;
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieDTO> findAllByActorsRatingGreaterThan(Double rating) {
        return movieRepository.findAllByActorsRatingGreaterThan(rating).stream()
                .map(MovieMapper::movieMap)
                .toList();
    }

    @Override
    public List<MovieDTO> findAllByGenreName(String genre) {
        return movieRepository.findAllByGenreName(genre).stream()
                .map(MovieMapper::movieMap)
                .toList();
    }
}
