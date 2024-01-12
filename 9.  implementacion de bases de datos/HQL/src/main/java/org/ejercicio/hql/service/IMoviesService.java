package org.ejercicio.hql.service;

import org.ejercicio.hql.model.dto.ActorDTO;
import org.ejercicio.hql.model.dto.EpisodeDTO;
import org.ejercicio.hql.model.dto.MovieDTO;
import org.ejercicio.hql.model.dto.SerieDTO;
import org.ejercicio.hql.model.entity.Actor;

import java.util.List;

public interface IMoviesService {
    List<ActorDTO> getActorsWithFavoriteMovies();

    List<ActorDTO> getActorsWithRatingSuperior(Double rating);

    List<ActorDTO> getActorsWorkOnMovie(Long movie);

    List<MovieDTO> getMoviesWithRatingActors(Double valueRating);

    List<MovieDTO> getMoviesGenre(Long genreId);

    List<SerieDTO> getSeriesWithSeasons(Integer valueSeasons);

    List<EpisodeDTO> getEpisodesWhenActorWork(Long actorId);
}
