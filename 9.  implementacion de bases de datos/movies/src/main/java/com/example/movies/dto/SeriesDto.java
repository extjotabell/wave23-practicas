package com.example.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SeriesDto implements Serializable {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
    private String title;
    private Instant releaseDate;
    private Instant endDate;
    private GenreDto genre;
}
