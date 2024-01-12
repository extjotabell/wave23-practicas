package com.meli.MoviesHQL.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meli.MoviesHQL.model.Episode;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EpisodeDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String title;
    Long number;
    Instant releaseDate;
    BigDecimal rating;
    SeasonDto season;

    public EpisodeDto(Episode episode) {
        this.id = episode.getId();
        this.createdAt = episode.getCreatedAt();
        this.updatedAt = episode.getUpdatedAt();
        this.title = episode.getTitle();
        this.number = episode.getNumber();
        this.releaseDate = episode.getReleaseDate();
        this.rating = episode.getRating();
        this.season = new SeasonDto(episode.getSeason());
    }
}