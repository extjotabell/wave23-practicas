package com.meli.MoviesHQL.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.MoviesHQL.model.Genre;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GenreDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String name;
    Long ranking;
    Boolean active;

    public GenreDto(Genre genre) {
        this.id = genre.getId();
        this.createdAt = genre.getCreatedAt();
        this.updatedAt = genre.getUpdatedAt();
        this.name = genre.getName();
        this.ranking = genre.getRanking();
        this.active = genre.getActive();
    }
}