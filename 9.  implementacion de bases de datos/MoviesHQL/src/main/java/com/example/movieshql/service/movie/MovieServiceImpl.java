package com.example.movieshql.service.movie;

import com.example.movieshql.dto.MovieDto;
import com.example.movieshql.model.Movie;
import com.example.movieshql.repository.GenreRepository;
import com.example.movieshql.repository.MovieRepository;
import com.example.movieshql.utils.DTOMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieServiceImpl(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public List<MovieDto> findMoviesByActorsWithHigherRatingThan(Double rating) {
        return movieRepository.findMoviesByActorsWithHigherRatingThan(rating).
                stream().map(DTOMapper::mapToMovieDTO).toList();
    }

    @Override
    public List<MovieDto> findMoviesByGenre(Long genreId) {
        return movieRepository.findMoviesByGenre(
                genreRepository.findById(genreId).orElseThrow())
                .stream().map(DTOMapper::mapToMovieDTO).toList();
    }
}
