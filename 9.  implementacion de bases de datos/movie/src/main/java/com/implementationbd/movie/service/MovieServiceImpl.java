package com.implementationbd.movie.service;

import com.implementationbd.movie.model.dto.MovieDto;
import com.implementationbd.movie.repository.IMovieRepository;
import com.implementationbd.movie.service.interfaces.IMovieService;
import com.implementationbd.movie.util.UtilConvert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    IMovieRepository repository;

    @Override
    public List<MovieDto> getMoviesWithRatingActorGreaterThan(double rating) {
        return repository.getMoviesWithRatingActorGreaterThan(rating)
                .stream()
                .map(UtilConvert::toDto)
                .toList();
    }

    @Override
    public List<MovieDto> getMoviesByGenreId(Long genreId) {
        return repository.getMoviesByGenreId(genreId)
                .stream()
                .map(UtilConvert::toDto)
                .toList();
    }
}
