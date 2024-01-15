package com.example.Hql.service;

import com.example.Hql.model.dto.ActorDto;
import com.example.Hql.model.dto.EpisodeDto;
import com.example.Hql.model.dto.MovieDto;
import com.example.Hql.model.dto.SerieDto;
import com.example.Hql.repository.IActorRepository;
import com.example.Hql.repository.IEpisodeRepository;
import com.example.Hql.repository.IMovieRepository;
import com.example.Hql.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoviesService implements IMoviesService{


    @Autowired
    IActorRepository actorRepository;

    @Autowired
    IMovieRepository movieRepository;

    @Autowired
    ISerieRepository serieRepository;

    @Autowired
    IEpisodeRepository episodeRepository;


    @Override
    public List<ActorDto> findFavoriteMovieOfActor() {
        return actorRepository.findByFavoriteMovieIdIsNotNull();
    }

    @Override
    public List<ActorDto> getActorsByRating(Double rating) {
        return actorRepository.findByRatingGreaterThan(rating);
    }

    @Override
    public List<ActorDto> getActorsThatWasInMovie(Long movieId) {
        return actorRepository.findActorByMovie(movieId);
    }

    @Override
    public List<MovieDto> getMoviesByActorRating(Double actorRating) {
        return movieRepository.findMoviesByActorsRatingGreaterThan(actorRating);
    }

    @Override
    public List<MovieDto> getMoviesByGenre(Long genreId) {
        return movieRepository.findByGenreIdEquals(genreId);
    }

    @Override
    public List<SerieDto> getNumeroTemporadasGreaterThan(Integer temporadas) {
        return serieRepository.findByNumeroTemporadasGreaterThan(temporadas);
    }

    @Override
    public List<EpisodeDto> getEpisodesByActor(String actorName) {
        return episodeRepository.findByActorNombre(actorName);
    }

}
