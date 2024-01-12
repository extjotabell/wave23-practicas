package com.practice.movies.service;

import com.practice.movies.dto.ActorDTO;
import com.practice.movies.dto.MovieDTO;
import com.practice.movies.dto.SerieDTO;
import com.practice.movies.dto.EpisodeDTO;

import java.util.List;

public interface IMoviesService {
    List<ActorDTO> listActorsWithFavMovie();

    List<ActorDTO> listActorsWithRatingOver(Double rating);

    List<ActorDTO> listActorsInMovie(Integer movieId);

    List<MovieDTO> listMoviesWithActorsRatingOver(Double rating);

    List<MovieDTO> listMoviesWithGenreId(Integer genreId);

    List<SerieDTO> listSeriesWithSeasonsNumberOver(Integer number);

    List<EpisodeDTO> listEpisodesWithActor(Integer actorId);
}
