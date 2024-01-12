package com.ospina.hql.util;

import com.ospina.hql.modelo.dto.ActorDto;
import com.ospina.hql.modelo.dto.PeliculaDto;
import com.ospina.hql.modelo.entidad.Actor;
import com.ospina.hql.modelo.entidad.Pelicula;

import java.util.List;
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

}
