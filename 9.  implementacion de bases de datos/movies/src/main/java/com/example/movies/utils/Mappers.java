package com.example.movies.utils;

import com.example.movies.dto.ActorDto;
import com.example.movies.dto.ActorsListDto;
import com.example.movies.dto.MovieDto;
import com.example.movies.dto.MoviesListDto;
import com.example.movies.model.Actor;
import com.example.movies.model.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

public class Mappers {
    private static final ObjectMapper mapper = new ObjectMapper() .registerModule(new JavaTimeModule());

    public static ActorsListDto actorsListToActorsListDto(List<Actor> actors){
        List<ActorDto> actorsList = actors.stream()
                .map(actor -> mapper.convertValue(actor, ActorDto.class))
                .toList();
        return new ActorsListDto(actorsList);
    }

    public static MoviesListDto moviesListToMoviesListDto(List<Movie> movies){
        List<MovieDto> moviesList = movies.stream()
                .map(movie -> mapper.convertValue(movie, MovieDto.class))
                .toList();
        return new MoviesListDto(moviesList);
    }

}
