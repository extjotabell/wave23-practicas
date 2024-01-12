package spring.movies.service;

import spring.movies.dto.ActorDto;
import spring.movies.dto.EpisodeDto;
import spring.movies.dto.MovieDto;
import spring.movies.dto.SeriesDto;
import spring.movies.model.Actor;
import spring.movies.model.Episode;
import spring.movies.model.Movie;
import spring.movies.model.Series;

import java.util.List;

public interface IMoviesService {
    List<ActorDto> getActorsWFavMovies();

    Integer getActorsWFavMoviesCount();

    List<ActorDto> getActorsByRating(Double rating);

    List<ActorDto> getActorsThatWorkIn(Long movieId);

    List<MovieDto> getMoviesActorRating(Double actorRating);

    List<MovieDto> getMoviesByGenre(Long genreId);

    List<SeriesDto> getByNumeroTemporadasGreaterThan(Integer temporadas) ;

    List<EpisodeDto> getEpisodesByActorName(String actorName);

    List<EpisodeDto> getEpisodesByActorId(Long actorId);
}
