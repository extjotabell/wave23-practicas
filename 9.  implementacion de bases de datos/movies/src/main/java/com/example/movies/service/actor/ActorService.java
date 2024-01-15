package com.example.movies.service.actor;

import com.example.movies.dto.ActorsListDto;

public interface ActorService {
    ActorsListDto findActorsWithFavoriteMovie();

    ActorsListDto findActorsWithRatingHigerThan(double rating);

    ActorsListDto findActorsInMovie(String movieTitle);
}
