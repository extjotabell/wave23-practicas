package com.mercadolibre.movieshql.utils;

import com.mercadolibre.movieshql.model.dtos.ActorsDTO;
import com.mercadolibre.movieshql.model.dtos.EpisodesDTO;
import com.mercadolibre.movieshql.model.dtos.GenresDTO;
import com.mercadolibre.movieshql.model.dtos.MoviesDTO;
import com.mercadolibre.movieshql.model.dtos.SeriesDTO;
import com.mercadolibre.movieshql.model.dtos.SeasonsDTO;
import com.mercadolibre.movieshql.model.entities.Actors;
import com.mercadolibre.movieshql.model.entities.Episodes;
import com.mercadolibre.movieshql.model.entities.Genres;
import com.mercadolibre.movieshql.model.entities.Movies;
import com.mercadolibre.movieshql.model.entities.Seasons;
import com.mercadolibre.movieshql.model.entities.Series;

public class MapperDTO {

    private MapperDTO() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static ActorsDTO mapActorsDTO(Actors actors) {
        if (actors == null){
            return null;
        }
        return new ActorsDTO(actors.getId(), actors.getFirstName(),
                actors.getLastName(), actors.getRating(), mapMoviesDTO(actors.getFavoriteMovies()));
    }

    public static MoviesDTO mapMoviesDTO(Movies movies) {
        if (movies == null) {
            return null;
        }
        return new MoviesDTO(movies.getId(), movies.getTitle(), movies.getRating(),
                movies.getAwards(), movies.getReleaseDate(), movies.getLength(), mapGenresDTO(movies.getGenres()));
    }

    public static GenresDTO mapGenresDTO(Genres genre) {
        if (genre == null) {
            return null;
        }
        return new GenresDTO(genre.getId(), genre.getName(), genre.getRanking(), genre.getActive());
    }

    public static SeriesDTO mapToSerieDTO(Series series) {
        if (series == null) {
            return null;
        }
        return new SeriesDTO(series.getId(), series.getTitle(),
                series.getReleaseDate(), series.getEndDate(), mapGenresDTO(series.getGenres()));
    }

    public static EpisodesDTO mapToEpisodeDTO(Episodes episode) {
        if (episode == null){
            return null;
        }
        return new EpisodesDTO(episode.getId(), episode.getTitle(), episode.getNumber(),
                episode.getReleaseDate(), episode.getRating(), mapToSeasonDTO(episode.getSeasons()));
    }

    public static SeasonsDTO mapToSeasonDTO(Seasons season) {
        if (season == null){
            return null;
        }
        return new SeasonsDTO(season.getId(), season.getTitle(), season.getNumber(),
                season.getReleaseDate(), season.getEndDate(), mapToSerieDTO(season.getSeries()));
    }
}
