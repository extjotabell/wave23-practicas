package com.example.movies.service.movie;

import com.example.movies.dto.MoviesListDto;
import com.example.movies.repository.MovieRepository;

public interface MovieService {

    MoviesListDto findMoviesWithGenre(String genre);
}
