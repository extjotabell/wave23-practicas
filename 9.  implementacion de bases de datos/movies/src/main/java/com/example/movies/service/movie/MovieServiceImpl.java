package com.example.movies.service.movie;

import com.example.movies.dto.MoviesListDto;
import com.example.movies.model.Movie;
import com.example.movies.repository.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.movies.utils.Mappers.moviesListToMoviesListDto;

@Service
public class MovieServiceImpl implements MovieService{

    private final MovieRepository repository;

    public MovieServiceImpl(MovieRepository repository) {
        this.repository = repository;
    }

    @Override
    public MoviesListDto findMoviesWithGenre(String genre) {
        List<Movie> movies = repository.fidMoviesWithGenre(genre);
        return moviesListToMoviesListDto(movies);
    }
}
