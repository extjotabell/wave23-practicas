package com.example.movies.service;

import com.example.movies.dto.ActorsListDto;

public interface MovieService {
    ActorsListDto findActorsWithFavoriteMovie();

    ActorsListDto findActorsWithRatingHigerThan(double rating);
}
