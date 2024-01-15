package com.example.Hql.service;

import com.example.Hql.model.dto.ActorDto;
import com.example.Hql.model.dto.EpisodeDto;
import com.example.Hql.model.dto.MovieDto;
import com.example.Hql.model.dto.SerieDto;

import java.util.List;

public interface IMoviesService {

    List<ActorDto> findFavoriteMovieOfActor();

    List<ActorDto> getActorsByRating(Double rating);

    List<ActorDto> getActorsThatWasInMovie(Long movieId);

    List<MovieDto> getMoviesByActorRating(Double actorRating);

    List<MovieDto> getMoviesByGenre(Long genreId);

    List<SerieDto> getNumeroTemporadasGreaterThan(Integer temporadas) ;

    List<EpisodeDto> getEpisodesByActor(String actorName);

}
