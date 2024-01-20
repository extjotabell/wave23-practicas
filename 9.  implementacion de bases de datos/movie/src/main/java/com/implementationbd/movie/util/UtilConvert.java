package com.implementationbd.movie.util;

import com.implementationbd.movie.model.dto.*;
import com.implementationbd.movie.model.entity.*;

import java.util.List;

public class UtilConvert {

    public static ActorDto toDto(Actor actor) {
        ActorDto dto = new ActorDto();
        dto.setFirstName(actor.getFirstName());
        dto.setLastName(actor.getLastName());
        dto.setRating(actor.getRating());

        if (actor.getFavoriteMovie() != null) {
            dto.setFavoriteMovie(toDto(actor.getFavoriteMovie()));
        }

        return dto;
    }

    public static MovieDto toDto(Movie movie) {
        MovieDto dto = new MovieDto();

        dto.setRating(movie.getRating());
        dto.setAwards(movie.getAwards());
        dto.setTitle(movie.getTitle());
        dto.setLength(movie.getLength());
        dto.setReleaseDate(movie.getReleaseDate());

        if (movie.getGenre() != null) {
            dto.setGenre(toDto(movie.getGenre()));
        }

        return dto;
    }

    public static GenreDto toDto(Genre genre) {
        if (genre == null) {
            return null;
        }

        GenreDto dto = new GenreDto();

        dto.setName(genre.getName());
        dto.setRanking(genre.getRanking());
        dto.setActive(genre.isActive());

        return dto;
    }

    public static EpisodeDto toDto(Episode episode) {
        EpisodeDto dto = new EpisodeDto();

        dto.setRating(episode.getRating());
        dto.setTitle(episode.getTitle());
        dto.setReleaseDate(episode.getReleaseDate());
        dto.setSeason(toDto(episode.getSeason()));
        dto.setNumber(episode.getNumber());

        return dto;
    }

    public static SeasonDto toDto(Season season) {
        SeasonDto dto = new SeasonDto();

        dto.setNumber(season.getNumber());
        dto.setReleaseDate(dto.getReleaseDate());
        dto.setRating(season.getRating());
        dto.setSeries(toDto(season.getSeries()));
        dto.setEpisodes(toDtoList(season.getEpisodes()));

        return dto;
    }

    private static List<EpisodeDto> toDtoList(List<Episode> episodes) {
        return episodes.stream().map(UtilConvert::toDto).toList();
    }

    public static SeriesDto toDto(Series serie) {
        SeriesDto dto = new SeriesDto();

        dto.setTitle(serie.getTitle());
        dto.setReleaseDate(serie.getReleaseDate());
        dto.setRating(serie.getRating());
        dto.setSeasons(toDto(serie.getSeasons()));

        return dto;
    }

    private static List<SeasonDto> toDto(List<Season> seasons) {
        return seasons.stream().map(UtilConvert::toDto).toList();
    }

}
