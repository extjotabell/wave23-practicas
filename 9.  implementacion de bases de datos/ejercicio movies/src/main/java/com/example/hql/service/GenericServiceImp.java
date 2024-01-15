package com.example.hql.service;

import com.example.hql.dto.*;
import com.example.hql.model.Actor;
import com.example.hql.model.Episode;
import com.example.hql.model.Movie;
import com.example.hql.model.Serie;
import com.example.hql.repository.IGenericRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericServiceImp implements IGenericService {
    private final IGenericRepo repo;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public GenericServiceImp(IGenericRepo repo) {
        this.repo = repo;
    }

    public ActorsListDTO getActorsWithFavoriteMovie() {
        List<Actor> actors = repo.getActorsWithFavoriteMovie();
        List<ActorDTO> actorsDTO = actors.stream().map(actor -> objectMapper.convertValue(actor, ActorDTO.class)).toList();
        return new ActorsListDTO(actorsDTO);
    }

    public ActorsListDTO getActorsWithRatingGraterThan(Double rating) {
        List<Actor> actors = repo.getActorsWithRatingGraterThan(rating);
        List<ActorDTO> actorsDTO = actors.stream().map(actor -> objectMapper.convertValue(actor, ActorDTO.class)).toList();
        return new ActorsListDTO(actorsDTO);
    }

    public ActorsListDTO getActorsStarredIn(Long movieId) {
        List<Actor> actors = repo.getActorsStarredIn(movieId);
        List<ActorDTO> actorsDTO = actors.stream().map(actor -> objectMapper.convertValue(actor, ActorDTO.class)).toList();
        return new ActorsListDTO(actorsDTO);
    }

    public MoviesListDTO getMoviesWithActorsRatingGraterThan(Double rating) {
        List<Movie> movies = repo.getMoviesWithActorsRatingGraterThan(rating);
        List<MovieDTO> moviesDTO = movies.stream().map(movie -> objectMapper.convertValue(movie, MovieDTO.class)).toList();
        return new MoviesListDTO(moviesDTO);
    }

    public MoviesListDTO getMoviesWithGenreLike(Long genreId) {
        List<Movie> movies = repo.getMoviesWithGenreLike(genreId);
        List<MovieDTO> moviesDTO = movies.stream().map(movie -> objectMapper.convertValue(movie, MovieDTO.class)).toList();
        return new MoviesListDTO(moviesDTO);
    }

    public SeriesListDTO getSeriesWithMoreSeasonsThan(int seasonsQuantity) {
        List<Serie> series = repo.getSeriesWithMoreSeasonsThan(seasonsQuantity);
        List<SerieDTO> seriesDTO = series.stream().map(serie -> objectMapper.convertValue(serie, SerieDTO.class)).toList();
        return new SeriesListDTO(seriesDTO);
    }

    public EpisodesListDTO getSeriesEpisodeWithStarredActor(Long actorId) {
        List<Episode> episodes = repo.getSeriesEpisodeWithStarredActor(actorId);
        List<EpisodeDTO> episodesDTO = episodes.stream().map(episode -> objectMapper.convertValue(episode, EpisodeDTO.class)).toList();
        return new EpisodesListDTO(episodesDTO);
    }
}