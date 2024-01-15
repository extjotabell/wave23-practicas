package com.example.ejercicioHQL.mappers;

import com.example.ejercicioHQL.dto.ActorDto;
import com.example.ejercicioHQL.dto.MovieDto;
import com.example.ejercicioHQL.dto.response.ActorAndFavoriteMovieDto;
import com.example.ejercicioHQL.model.Actor;

public class ActorMapper {

    private MovieMapper movieMapper;

    public ActorMapper(){
        movieMapper = new MovieMapper();
    }

    public ActorDto mapActorDto(Actor actor){
        return new ActorDto(
                actor.getId(),
                actor.getFirstName(),
                actor.getLastName(),
                actor.getRating()
        );
    }

    public ActorAndFavoriteMovieDto mapActorAndFavoriteMovieDto(Actor actor){
        MovieDto favoriteMovieDto = actor.getFavoriteMovie() != null ? movieMapper.mapMovieDto(actor.getFavoriteMovie()) : null;
        return new ActorAndFavoriteMovieDto(
                actor.getId(),
                actor.getFirstName(),
                actor.getLastName(),
                actor.getRating(),
                favoriteMovieDto
        );
    }

}
