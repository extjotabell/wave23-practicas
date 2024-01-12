package com.example.movies.utils;

import com.example.movies.dto.ActorFavoriteMovieDTO;
import com.example.movies.dto.ActorSimpleDTO;
import com.example.movies.dto.MovieSimpleDTO;
import com.example.movies.dto.SerieNumberSeasonDTO;
import com.example.movies.models.Actor;
import com.example.movies.models.Movie;
import com.example.movies.models.Serie;

public class Mapper {

  public static ActorFavoriteMovieDTO actorToActorFavoriteMovieDTO(Actor actor) {
    return new ActorFavoriteMovieDTO(actor.getId(), actor.getFirstName(), actor.getLastName(),
        actor.getRating(), movieToMovieSimpleDTO(actor.getFavoriteMovie()));
  }

  public static ActorSimpleDTO actorToActorSimpleDTO(Actor actor) {
    return new ActorSimpleDTO(actor.getId(), actor.getFirstName(), actor.getLastName(),
        actor.getRating());
  }

  public static MovieSimpleDTO movieToMovieSimpleDTO(Movie movie) {
    return new MovieSimpleDTO(movie.getId(), movie.getTitle(), movie.getRating(), movie.getAwards(),
        movie.getReleaseDate(), movie.getLength());
  }

  public static SerieNumberSeasonDTO serieToSerieNumberSeasonDTO(Serie serie) {
    System.out.println(

        serie.getSeasons()

    );
    return new SerieNumberSeasonDTO(serie.getId(), serie.getTitle(), serie.getReleaseDate(),
        serie.getEndDate(), (long) serie.getSeasons().size());
  }

}
