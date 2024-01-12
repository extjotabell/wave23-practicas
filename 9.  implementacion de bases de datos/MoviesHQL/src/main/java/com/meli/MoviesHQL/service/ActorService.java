package com.meli.MoviesHQL.service;

import com.meli.MoviesHQL.dto.ActorDto;
import com.meli.MoviesHQL.model.Actor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActorService {

    List<ActorDto> findByFavoriteMovieIsNotNull();
    List<ActorDto> findByRatingIsGreaterThanEqual(Double rating);
    List<ActorDto> findByMovie(Long movieId);

}
