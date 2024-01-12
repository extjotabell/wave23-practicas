package com.meli.MoviesHQL.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.MoviesHQL.model.Movie;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String title;
    BigDecimal rating;
    Long awards;
    Instant releaseDate;
    Long length;
    GenreDto genre;

    public MovieDto(Movie movie) {
        this.id = movie.getId();
        this.createdAt = movie.getCreatedAt();
        this.updatedAt = movie.getUpdatedAt();
        this.title = movie.getTitle();
        this.rating = movie.getRating();
        this.awards = movie.getAwards();
        this.releaseDate = movie.getReleaseDate();
        this.length = movie.getLength();

        if (movie.getGenre() != null) this.genre = new GenreDto(movie.getGenre());
    }
}