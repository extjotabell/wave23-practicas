package com.example.movieshql.utils;

import com.example.movieshql.dto.*;
import com.example.movieshql.model.*;

public class DTOMapper {
    public static ActorDto mapToActorDTO(Actor actor) {
        if (actor == null) return null;
        return new ActorDto(actor.getId(), actor.getCreatedAt(), actor.getUpdatedAt(), actor.getFirstName(),
                actor.getLastName(), actor.getRating(), mapToMovieDTO(actor.getFavoriteMovie()));
    }

    public static MovieDto mapToMovieDTO(Movie movie) {
        if (movie == null) return null;
        return new MovieDto(movie.getId(), movie.getCreatedAt(), movie.getUpdatedAt(), movie.getTitle(),
                movie.getRating(), movie.getAwards(), movie.getReleaseDate(), movie.getLength(), mapToGenreDTO(movie.getGenre()));
    }

    public static GenreDto mapToGenreDTO(Genre genre) {
        if (genre == null) return null;
        return new GenreDto(genre.getId(), genre.getCreatedAt(), genre.getUpdatedAt(), genre.getName(),
                genre.getRanking(), genre.getActive());
    }

    public static SeriesDto mapToSerieDTO(Serie serie) {
        if (serie == null) return null;
        return new SeriesDto(serie.getId(), serie.getCreatedAt(), serie.getUpdatedAt(), serie.getTitle(),
                serie.getReleaseDate(), serie.getEndDate(), mapToGenreDTO(serie.getGenre()));
    }

    public static EpisodeDto mapToEpisodeDTO(Episode episode) {
        if (episode == null) return null;
        return new EpisodeDto(episode.getId(), episode.getCreatedAt(), episode.getUpdatedAt(), episode.getTitle(),
                episode.getNumber(), episode.getReleaseDate(), episode.getRating(), mapToSeasonDTO(episode.getSeason()));
    }

    public static SeasonDto mapToSeasonDTO(Season season) {
        if (season == null) return null;
        return new SeasonDto(season.getId(), season.getCreatedAt(), season.getUpdatedAt(), season.getTitle(),
                season.getNumber(), season.getReleaseDate(), season.getEndDate(), mapToSerieDTO(season.getSerie()));
    }
}
