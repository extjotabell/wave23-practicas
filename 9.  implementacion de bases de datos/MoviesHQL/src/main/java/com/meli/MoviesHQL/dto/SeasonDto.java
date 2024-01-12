package com.meli.MoviesHQL.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.MoviesHQL.model.Season;
import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SeasonDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String title;
    Long number;
    Instant releaseDate;
    Instant endDate;
    SerieDto serie;

    public SeasonDto(Season season) {
        this.id = season.getId();
        this.createdAt = season.getCreatedAt();
        this.updatedAt = season.getUpdatedAt();
        this.title = season.getTitle();
        this.number = season.getNumber();
        this.releaseDate = season.getReleaseDate();
        this.endDate = season.getEndDate();
        this.serie = new SerieDto(season.getSerie());
    }
}