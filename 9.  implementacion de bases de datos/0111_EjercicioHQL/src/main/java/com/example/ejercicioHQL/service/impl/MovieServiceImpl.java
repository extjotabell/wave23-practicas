package com.example.ejercicioHQL.service.impl;

import com.example.ejercicioHQL.dto.ActorDto;
import com.example.ejercicioHQL.dto.MovieDto;
import com.example.ejercicioHQL.mappers.ActorMapper;
import com.example.ejercicioHQL.mappers.MovieMapper;
import com.example.ejercicioHQL.repository.MovieRepository;
import com.example.ejercicioHQL.service.IMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements IMovieService {

    @Autowired
    MovieRepository movieRepository;

    @Override
    public List<ActorDto> findActorsByMovieName(String titleName) {

        ActorMapper actorMapper = new ActorMapper();

        return movieRepository.findActorsByName(titleName)
                .stream()
                .map(actorMapper::mapActorDto)
                .toList();
    }

    @Override
    public List<MovieDto> findByActorsRating(Double rating) {
        MovieMapper movieMapper = new MovieMapper();

        return movieRepository.findByActorsRating(rating)
                .stream()
                .map(movieMapper::mapMovieDto)
                .toList();
    }

    @Override
    public List<MovieDto> findByGenreName(String genre) {
        MovieMapper movieMapper = new MovieMapper();
        return movieRepository.findByGenreName(genre)
                .stream()
                .map(movieMapper::mapMovieDto)
                .toList();
    }
}
