package org.ejercicio.hql.service;

import org.ejercicio.hql.model.dto.ActorDTO;
import org.ejercicio.hql.model.dto.EpisodeDTO;
import org.ejercicio.hql.model.dto.MovieDTO;
import org.ejercicio.hql.model.dto.SerieDTO;
import org.ejercicio.hql.repository.IMoviesRepository;
import org.ejercicio.hql.utils.ActorMapper;
import org.ejercicio.hql.utils.EpisodeMapper;
import org.ejercicio.hql.utils.MovieMapper;
import org.ejercicio.hql.utils.SerieMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MoviesServiceImpl implements IMoviesService {
    private final IMoviesRepository repository;

    public MoviesServiceImpl(IMoviesRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ActorDTO> getActorsWithFavoriteMovies() {
        return repository.getActorWithFavoriteMovie().stream().map(ActorMapper::actorMap).toList();
    }

    @Override
    public List<ActorDTO> getActorsWithRatingSuperior(Double rating) {
        return repository.getActorsWithRatingSuperior(rating).stream().map(ActorMapper::actorMap).toList();
    }

    @Override
    public List<ActorDTO> getActorsWorkOnMovie(Long movieId) {
        return repository.getActorsWorkOnMovie(movieId).stream().map(ActorMapper::actorMap).toList();
    }

    @Override
    public List<MovieDTO> getMoviesWithRatingActors(Double valueRating) {
        return repository.getMoviesWithRatingActors(valueRating).stream().map(MovieMapper::MovieMap).toList();
    }

    @Override
    public List<MovieDTO> getMoviesGenre(Long genreId) {
        return repository.getMoviesGenre(genreId).stream().map(MovieMapper::MovieMap).toList();
    }

    @Override
    public List<SerieDTO> getSeriesWithSeasons(Integer valueSeasons) {
        return repository.getSeriesWithSeasons(valueSeasons).stream().map(SerieMapper::serieMap).toList();
    }

    @Override
    public List<EpisodeDTO> getEpisodesWhenActorWork(Long actorId) {
        return repository.getEpisodesWhenActorWork(actorId).stream().map(EpisodeMapper::episodeMap).toList();
    }
}
