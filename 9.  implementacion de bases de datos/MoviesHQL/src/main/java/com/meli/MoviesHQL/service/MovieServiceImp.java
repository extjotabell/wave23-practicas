package com.meli.MoviesHQL.service;

import com.meli.MoviesHQL.dto.MovieDto;
import com.meli.MoviesHQL.exception.NotFoundException;
import com.meli.MoviesHQL.model.Movie;
import com.meli.MoviesHQL.repository.GenreRepository;
import com.meli.MoviesHQL.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImp implements MovieService {

    MovieRepository movieRepository;
    GenreRepository genreRepository;

    public MovieServiceImp(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<MovieDto> findByActorsRatingGreaterThan(Double rating) {
        List<Movie> movies = movieRepository.findByActorsRatingGreaterThan(rating);
        return movies.stream().map(MovieDto::new).toList();
    }

    @Override
    public List<MovieDto> findByGenre(Long genreId) {
        // Check if genre exists
        genreRepository.findById(genreId).orElseThrow(() -> new NotFoundException("Genre not found"));

        List<Movie> movies = movieRepository.findByGenre(genreId);
        return movies.stream().map(MovieDto::new).toList();
    }
}
