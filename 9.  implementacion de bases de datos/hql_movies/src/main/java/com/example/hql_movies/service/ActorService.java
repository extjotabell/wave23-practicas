package com.example.hql_movies.service;

import com.example.hql_movies.model.*;
import com.example.hql_movies.repository.IActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    @Autowired
    IActorRepository repository;
    public List<Actor> obtenerActores(){
        return repository.findAllactors();
    }

    public List<String> findFirstName(){
        return repository.findFirstName();
    }

    public List<Actor> findActorWithFavoriteMovie(){
        return repository.findAllactorsWithFavoriteMovie();
    }

    public List<Actor> findActorRaiting(Double rating){
        return repository.findActorRating(rating);
    }

    public List<Actor> findMovie(String title){
        return repository.findMovie(title);
    }

    public List<Movie> findMovieActorRating(Double rating){
        return repository.findMovieActorRating(rating);
    }

    public List<Movie> findMovieGender(String genre){
        return repository.findMovieGender(genre);
    }

    public List<Movie> findAllMovie(){
        return repository.findAllMovie();
    }

    public List<Serie> findSerieRating(){
        return repository.findSerieRating();
    }

    public List<Season> findAllSeason(){
        return repository.findAllSeason();
    }

    public List<Episode> findEpisodes() {
        return repository.findEpisodes();
    }

    public List<Serie> findSerieNumber(Integer number) {
        return repository.findSerieSeasonNumber(number);
    }

    public List<Episode> findActorEpisode(String actor){
        return repository.findEpisodeActor(actor);
    }

}
