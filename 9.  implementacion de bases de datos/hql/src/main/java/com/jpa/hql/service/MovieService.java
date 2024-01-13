package com.jpa.hql.service;

import com.jpa.hql.model.dto.MovieDTO;
import com.jpa.hql.model.entity.GenreEntity;
import com.jpa.hql.repository.IGenreRepository;
import com.jpa.hql.repository.IMovieRepository;
import com.jpa.hql.utils.IMappingUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService implements IMovieService{
    @Autowired
    private IMovieRepository movieRepository;
    @Autowired
    private IGenreRepository genreRepository;
    @Autowired
    private IMappingUtility mappingUtility;
    @Override
    public Set<MovieDTO> getAllMoviesWithActorsWithRatingGreaterThan(BigDecimal rating) {
        return movieRepository.findByActorsWithRatingGreaterThan(rating).stream()
                .map(mE -> mappingUtility.movieEntityToDTO(mE))
                .collect(Collectors.toSet());
    }

    @Override
    public Set<MovieDTO> getAllMoviesByGenre(String genreName) {
        GenreEntity genre = genreRepository.findByNameEquals(genreName);
        return movieRepository.findByGenreEquals(genre).stream()
                .map(mE -> mappingUtility.movieEntityToDTO(mE))
                .collect(Collectors.toSet());
    }
}
