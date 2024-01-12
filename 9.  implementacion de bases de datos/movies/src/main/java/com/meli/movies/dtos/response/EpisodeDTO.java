package com.meli.movies.dtos.response;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDTO {
    private String title;
    private Integer number;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    private Double rating;
    private SeasonDTO season;
}
