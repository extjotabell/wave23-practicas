package com.example.movies.service;

import com.example.movies.model.dto.ActorsDTO;
import com.example.movies.model.dto.EpisodesDTO;
import com.example.movies.model.dto.MoviedDTO;
import com.example.movies.model.dto.SeriesDTO;
import com.example.movies.model.entities.Actors;
import com.example.movies.model.entities.Episodes;
import com.example.movies.model.entities.Movies;
import com.example.movies.model.entities.Series;
import com.example.movies.repository.GenericRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenericService {
    private GenericRepository repository;
    private final ModelMapper mapper = new ModelMapper();

    public GenericService(GenericRepository repository) {
        this.repository = repository;
    }

    //Listar todos los actores que tengan declarada una película favorita.
    public ResponseEntity<?> getActorsWithFavorteMovie() {
        List<Actors> actors = repository.getActorsWithFavorteMovie();
        List<ActorsDTO> actorsDTOList = actors.stream()
                .map(actor -> mapper.map(actor, ActorsDTO.class))
                .toList();
        return new ResponseEntity<>(actorsDTOList, HttpStatus.OK);
    }

    //Listar todos los actores que tengan rating superior a <valor recibido por parámetro>
    public ResponseEntity<?> getActorsRatingThant(Double rating) {
        List<Actors> actors = repository.getActorsRatingThant(rating);
        List<ActorsDTO> actorsDTOList = actors.stream()
                .map(actor -> mapper.map(actor, ActorsDTO.class))
                .toList();
        return new ResponseEntity<>(actorsDTOList, HttpStatus.OK);
    }
    //Listar todos los actores que trabajan en la <película recibida por parámetro
    public ResponseEntity<?> getActorsWorkIn(Long movieId) {
        List<Actors> actors = repository.getActorsWorkIn(movieId);
        List<ActorsDTO> actorsDTOList = actors.stream()
                .map(actor -> mapper.map(actor, ActorsDTO.class))
                .toList();
        return new ResponseEntity<>(actorsDTOList, HttpStatus.OK);
    }

    //Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>
    public ResponseEntity<?> getMoviesWithActorsRating(Double rating) {
        List<Movies> movies = repository.getMoviesWithActorsRating(rating);
        List<MoviedDTO> actorsDTOList = movies.stream()
                .map(m -> mapper.map(m, MoviedDTO.class))
                .toList();
        return new ResponseEntity<>(actorsDTOList, HttpStatus.OK);
    }

    //Listar todas las películas que pertenezcan al <género recibido por parámetro>
    public ResponseEntity<?> getMoviesWithGenreIn(Long genreId) {
        List<Movies> movies = repository.getMoviesWithGenreIn(genreId);
        List<MoviedDTO> actorsDTOList = movies.stream()
                .map(m -> mapper.map(m, MoviedDTO.class))
                .toList();
        return new ResponseEntity<>(actorsDTOList, HttpStatus.OK);
    }

    //Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>
    public ResponseEntity<?> getSeriesWithMore(int seasonsQ) {
        List<Series> series = repository.getSeriesWithMore(seasonsQ);
        List<SeriesDTO> seriesDTOList = series.stream()
                .map(s -> mapper.map(s, SeriesDTO.class))
                .toList();
        return new ResponseEntity<>(seriesDTOList, HttpStatus.OK);
    }

    //Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>
    public ResponseEntity<?> getEpisodesWithActor(Long actorId) {
        List<Episodes> episodes = repository.getEpisodesWithActor(actorId);
        List<EpisodesDTO> episodesDTOSList = episodes.stream()
                .map(s -> mapper.map(s, EpisodesDTO.class))
                .toList();
        return new ResponseEntity<>(episodesDTOSList, HttpStatus.OK);
    }
}
