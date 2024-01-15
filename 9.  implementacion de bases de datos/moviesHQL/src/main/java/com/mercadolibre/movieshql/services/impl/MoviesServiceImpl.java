package com.mercadolibre.movieshql.services.impl;

import com.mercadolibre.movieshql.model.dtos.MoviesDTO;
import com.mercadolibre.movieshql.model.entities.Genres;
import com.mercadolibre.movieshql.repositories.IGenresRepository;
import com.mercadolibre.movieshql.repositories.IMoviesRepository;
import com.mercadolibre.movieshql.services.IMoviesService;
import com.mercadolibre.movieshql.utils.MapperDTO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MoviesServiceImpl implements IMoviesService{

    private final IMoviesRepository moviesRepository;
    private final IGenresRepository genresRepository;

    public MoviesServiceImpl(IMoviesRepository moviesRepository, IGenresRepository genresRepository) {
        this.moviesRepository = moviesRepository;
        this.genresRepository = genresRepository;
    }

    @Override
    @Transactional
    public List<MoviesDTO> findMoviesByGenre(String genresName) {
        Genres genre = genresRepository.findByName(genresName);
        return moviesRepository.findMoviesByGenre(genre).stream().map(MapperDTO::mapMoviesDTO).toList();
    }

    @Override
    public List<MoviesDTO> findActorsWithRatingHigherThanRatingValue(Double rating) {
        return moviesRepository.findMoviesByActorRating(rating).stream().map(MapperDTO::mapMoviesDTO).toList();
    }
}
