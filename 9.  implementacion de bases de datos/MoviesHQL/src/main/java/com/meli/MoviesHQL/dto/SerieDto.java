package com.meli.MoviesHQL.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.MoviesHQL.model.Serie;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SerieDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String title;
    Instant releaseDate;
    Instant endDate;
    GenreDto genre;

    public SerieDto(Serie serie) {
        this.id = serie.getId();
        this.createdAt = serie.getCreatedAt();
        this.updatedAt = serie.getUpdatedAt();
        this.title = serie.getTitle();
        this.releaseDate = serie.getReleaseDate();
        this.endDate = serie.getEndDate();
        this.genre = new GenreDto(serie.getGenre());
    }
}