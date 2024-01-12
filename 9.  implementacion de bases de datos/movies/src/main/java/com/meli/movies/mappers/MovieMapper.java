package com.meli.movies.mappers;

import com.meli.movies.dtos.response.GenreDTO;
import com.meli.movies.dtos.response.MovieActorsDTO;
import com.meli.movies.dtos.response.MovieDTO;
import com.meli.movies.model.Movie;

import java.util.stream.Collectors;

public class MovieMapper {

    private MovieMapper(){}

    public static MovieDTO toDTO(Movie movie) {
        GenreDTO genre = movie.getGenre() != null ? GenreMapper.toDTO(movie.getGenre()) : null;
        return new MovieDTO(
                movie.getTitle(),
                movie.getRating(),
                movie.getAwards(),
                movie.getReleaseDate(),
                movie.getLength(),
                genre
        );
    }

    public static MovieActorsDTO toActorsDTO(Movie movie) {
        GenreDTO genre = movie.getGenre() != null ? GenreMapper.toDTO(movie.getGenre()) : null;
        return new MovieActorsDTO(
                movie.getCreatedAt(),
                movie.getUpdatedAt(),
                movie.getTitle(),
                movie.getRating(),
                movie.getAwards(),
                movie.getReleaseDate(),
                movie.getLength(),
                genre,
                movie.getActors().stream()
                        .map(ActorMapper::toDTO)
                        .collect(Collectors.toSet())
        );
    }


}
