package com.ospina.hql.util;

import com.ospina.hql.modelo.dto.*;
import com.ospina.hql.modelo.entidad.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DTOMapper {

    public static ActorDto toActorDto(Actor actor) {
        PeliculaDto favoriteMovieDto = null;
        Pelicula favoriteMovie = actor.getFavoriteMovie();
        if (favoriteMovie != null) {
            favoriteMovieDto = new PeliculaDto(
                    favoriteMovie.getId(),
                    favoriteMovie.getCreatedAt(),
                    favoriteMovie.getUpdatedAt(),
                    favoriteMovie.getTitle(),
                    favoriteMovie.getRating(),
                    favoriteMovie.getAwards(),
                    favoriteMovie.getReleaseDate(),
                    favoriteMovie.getLength(),
                    favoriteMovie.getGenreId()
            );
        }

        return new ActorDto(
                actor.getId(),
                actor.getCreatedAt(),
                actor.getUpdatedAt(),
                actor.getFirstName(),
                actor.getLastName(),
                actor.getRating(),
                favoriteMovieDto
        );
    }

    public static List<ActorDto> toActorDtoList(List<Actor> actors) {
        return actors.stream()
                .map(DTOMapper::toActorDto)
                .collect(Collectors.toList());
    }

    public static PeliculaDto toPeliculaDto(Pelicula pelicula) {
        return new PeliculaDto(
                pelicula.getId(),
                pelicula.getCreatedAt(),
                pelicula.getUpdatedAt(),
                pelicula.getTitle(),
                pelicula.getRating(),
                pelicula.getAwards(),
                pelicula.getReleaseDate(),
                pelicula.getLength(),
                pelicula.getGenreId()
        );
    }

    public static List<PeliculaDto> toPeliculaDtoList(List<Pelicula> peliculas) {
        return peliculas.stream()
                .map(DTOMapper::toPeliculaDto)
                .collect(Collectors.toList());
    }

    public static SeriesDto toSeriesDto(Series series) {
        Set<SeasonDto> seasonDtos = series.getSeasons().stream()
                .map(DTOMapper::toSeasonDto)
                .collect(Collectors.toSet());

        return new SeriesDto(
                series.getId(),
                series.getCreatedAt(),
                series.getUpdatedAt(),
                series.getTitle(),
                series.getReleaseDate(),
                series.getEndDate(),
                series.getGenreId(),
                seasonDtos
        );
    }

    public static List<SeriesDto> toSeriesDtoList(List<Series> seriesList) {
        return seriesList.stream()
                .map(DTOMapper::toSeriesDto)
                .collect(Collectors.toList());
    }

    public static SeasonDto toSeasonDto(Season season) {
        Set<EpisodeDto> episodeDtos = season.getEpisodes().stream()
                .map(DTOMapper::toEpisodeDto)
                .collect(Collectors.toSet());

        return new SeasonDto(
                season.getId(),
                season.getCreatedAt(),
                season.getUpdatedAt(),
                season.getTitle(),
                season.getNumber(),
                season.getReleaseDate(),
                season.getEndDate(),
                episodeDtos
        );
    }

    public static List<SeasonDto> toSeasonDtoList(List<Season> seasonList) {
        return seasonList.stream()
                .map(DTOMapper::toSeasonDto)
                .collect(Collectors.toList());
    }

    public static EpisodeDto toEpisodeDto(Episode episode) {
        return new EpisodeDto(
                episode.getId(),
                episode.getCreatedAt(),
                episode.getUpdatedAt(),
                episode.getTitle(),
                episode.getNumber(),
                episode.getReleaseDate(),
                episode.getRating()
        );
    }

    public static List<EpisodeDto> toEpisodeDtoList(List<Episode> episodeList) {
        return episodeList.stream()
                .map(DTOMapper::toEpisodeDto)
                .collect(Collectors.toList());
    }

}
