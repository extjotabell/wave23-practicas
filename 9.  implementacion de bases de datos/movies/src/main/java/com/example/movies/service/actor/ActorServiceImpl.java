package com.example.movies.service.actor;

import com.example.movies.dto.ActorsListDto;
import com.example.movies.model.Actor;
import com.example.movies.repository.ActorRepository;
import com.example.movies.service.actor.ActorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.util.List;

import static com.example.movies.utils.Mappers.actorsListToActorsListDto;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository repository;
    ObjectMapper mapper = new ObjectMapper();


    public ActorServiceImpl(ActorRepository repository) {
        this.repository = repository;
    }

    @Override
    public ActorsListDto findActorsWithFavoriteMovie() {
        List<Actor> actors =repository.findActorsByFavoriteMovieNotNull();
        return actorsListToActorsListDto(actors);
    }

    @Override
    public ActorsListDto findActorsWithRatingHigerThan(double rating) {
        List<Actor> actors =repository.findActorsWithRatingHigerThan(rating);
        return actorsListToActorsListDto(actors);
    }

    @Override
    public ActorsListDto findActorsInMovie(String movieTitle) {
        List<Actor> actors =repository.findActorsInMovie(movieTitle);
        return  actorsListToActorsListDto(actors);
    }
}
