package com.example.hql.service;

import com.example.hql.dto.ActorsListDTO;
import com.example.hql.dto.EpisodesListDTO;
import com.example.hql.dto.MoviesListDTO;
import com.example.hql.dto.SeriesListDTO;

public interface IGenericService {
    ActorsListDTO getActorsWithFavoriteMovie();
    ActorsListDTO getActorsWithRatingGraterThan(Double rating);
    ActorsListDTO getActorsStarredIn(Long movieId);
    MoviesListDTO getMoviesWithActorsRatingGraterThan(Double rating);
    MoviesListDTO getMoviesWithGenreLike(Long genreId);
    SeriesListDTO getSeriesWithMoreSeasonsThan(int seasonsQuantity);
    EpisodesListDTO getSeriesEpisodeWithStarredActor(Long actorId);
}
