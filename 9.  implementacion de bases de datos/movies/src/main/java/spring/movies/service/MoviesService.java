package spring.movies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.movies.dto.ActorDto;
import spring.movies.dto.EpisodeDto;
import spring.movies.dto.MovieDto;
import spring.movies.dto.SeriesDto;
import spring.movies.repository.IActorsRepository;
import spring.movies.repository.IEpisodesRepository;
import spring.movies.repository.IMoviesRepository;
import spring.movies.repository.ISeriesRepository;

import java.util.List;

@Service
public class MoviesService implements IMoviesService{

    @Autowired
    IActorsRepository actorsRepository;
    @Autowired
    IEpisodesRepository episodesRepository;
    @Autowired
    IMoviesRepository moviesRepository;
    @Autowired
    ISeriesRepository seriesRepository;

    @Override
    public List<ActorDto> getActorsWFavMovies() {
        return actorsRepository.findByFavoriteMovieIdIsNotNull();
    }

    @Override
    public Integer getActorsWFavMoviesCount() {
        return actorsRepository.findByFavoriteMovieIdIsNotNull().size();
    }

    @Override
    public List<ActorDto> getActorsByRating(Double rating) {
        return actorsRepository.findByRatingGreaterThan(rating);
    }

    @Override
    public List<ActorDto> getActorsThatWorkIn(Long movieId) {
        return actorsRepository.findActorByMovie(movieId);
    }

    @Override
    public List<MovieDto> getMoviesActorRating(Double actorRating) {
        return moviesRepository.findMoviesByActorsRatingGreaterThan(actorRating);
    }

    @Override
    public List<MovieDto> getMoviesByGenre(Long genreId) {
        return moviesRepository.findByGenreIdEquals(genreId);
    }

    @Override
    public List<SeriesDto> getByNumeroTemporadasGreaterThan(Integer temporadas) {
        return seriesRepository.findByNumeroTemporadasGreaterThan(temporadas);
    }

    @Override
    public List<EpisodeDto> getEpisodesByActorName(String actorName) {
        return episodesRepository.findByActorNombre(actorName);
    }

    @Override
    public List<EpisodeDto> getEpisodesByActorId(Long actorId) {
        return episodesRepository.findByActor(actorId);
    }
}
