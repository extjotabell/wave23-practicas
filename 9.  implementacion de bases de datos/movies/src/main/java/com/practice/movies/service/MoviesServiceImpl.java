package com.practice.movies.service;

import com.practice.movies.dto.ActorDTO;
import com.practice.movies.dto.EpisodeDTO;
import com.practice.movies.dto.MovieDTO;
import com.practice.movies.dto.SerieDTO;
import com.practice.movies.mapper.ModelToDTO;
import com.practice.movies.model.Actor;
import com.practice.movies.model.Episode;
import com.practice.movies.model.Movie;
import com.practice.movies.model.Serie;
import com.practice.movies.repository.GenericRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesServiceImpl implements IMoviesService {

    private GenericRepository repository;
    public MoviesServiceImpl(GenericRepository repository){
        this.repository = repository;
    }
    @Override
    public List<ActorDTO> listActorsWithFavMovie() {
        List<Actor> actors = repository.listActorsWithFavMovie();
        return actors.stream().map(ModelToDTO::mapActorToActorDTO).toList();
    }

    @Override
    public List<ActorDTO> listActorsWithRatingOver(Double rating) {
        List<Actor> actors = repository.listActorsWithRatingOver(rating);
        return actors.stream().map(ModelToDTO::mapActorToActorDTO).toList();
    }

    @Override
    public List<ActorDTO> listActorsInMovie(Integer movieId) {
        List<Actor> actors = repository.listActorsInMovie(movieId);
        return actors.stream().map(ModelToDTO::mapActorToActorDTO).toList();
    }

    @Override
    public List<MovieDTO> listMoviesWithActorsRatingOver(Double rating) {
        List<Movie> movies = repository.listMoviesWithActorsRatingOver(rating);
        return movies.stream().map(ModelToDTO::mapMovieToMovieDTO).toList();
    }

    @Override
    public List<MovieDTO> listMoviesWithGenreId(Integer genreId) {
        List<Movie> movies = repository.listMoviesWithGenreId(genreId);
        return movies.stream().map(ModelToDTO::mapMovieToMovieDTO).toList();
    }

    @Override
    public List<SerieDTO> listSeriesWithSeasonsNumberOver(Integer number) {
        List<Serie> series = repository.listSeriesWithSeasonsNumberOver(number);
        return series.stream().map(ModelToDTO::mapSerieToSerieDTO).toList();
    }

    @Override
    public List<EpisodeDTO> listEpisodesWithActor(Integer actorId) {
        List<Episode> episodes = repository.listEpisodesWithActor(actorId);
        return episodes.stream().map(ModelToDTO::mapEpisodeToEpisodeDTO).toList();
    }
}
