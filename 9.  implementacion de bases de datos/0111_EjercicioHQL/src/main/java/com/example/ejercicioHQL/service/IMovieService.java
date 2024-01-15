package com.example.ejercicioHQL.service;

import com.example.ejercicioHQL.dto.ActorDto;
import com.example.ejercicioHQL.dto.MovieDto;

import java.util.List;

public interface IMovieService {

    public List<ActorDto> findActorsByMovieName(String titleName);
    public List<MovieDto> findByActorsRating(Double rating);
    public List<MovieDto> findByGenreName(String genre);

}
