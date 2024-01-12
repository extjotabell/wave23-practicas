package com.practice.movies.mapper;

import com.practice.movies.dto.ActorDTO;
import com.practice.movies.dto.EpisodeDTO;
import com.practice.movies.dto.MovieDTO;
import com.practice.movies.dto.SerieDTO;
import com.practice.movies.model.*;

public class ModelToDTO {

    public static ActorDTO mapActorToActorDTO(Actor actor){
        Integer favMovieId = null;
        Movie favMovie = actor.getFavouriteMovie();
        if(favMovie != null) {favMovieId = favMovie.getId();}

        return new ActorDTO(actor.getId(), actor.getFirstName(), actor.getLastName(),
                actor.getRating(), favMovieId,
                actor.getCreatedAt(), actor.getUpdatedAt());
    }

    public static MovieDTO mapMovieToMovieDTO(Movie movie){
        Integer genreId = null;
        Genre genre = movie.getGenre();
        if(genre != null) {genreId = genre.getId();}

        return new MovieDTO(movie.getId(), movie.getTitle(), movie.getRating(),
                movie.getAwards(), movie.getReleaseDate(), movie.getLength(),
                genreId, movie.getCreatedAt(), movie.getUpdatedAt());
    }

    public static SerieDTO mapSerieToSerieDTO(Serie serie) {
        return new SerieDTO(serie.getId(), serie.getTitle(), serie.getReleaseDate(),
                serie.getRating(), serie.getSeasons().stream().map(Season::getId).toList());
    }

    public static EpisodeDTO mapEpisodeToEpisodeDTO(Episode episode) {
        Integer seasonId = null;
        Season season = episode.getSeason();
        if(season != null) {seasonId = season.getId();}

        return new EpisodeDTO(episode.getId(), episode.getTitle(), episode.getNumber(),
                episode.getReleaseDate(), episode.getRating(), seasonId);
    }
}
