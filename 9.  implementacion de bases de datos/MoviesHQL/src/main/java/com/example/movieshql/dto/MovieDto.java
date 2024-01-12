package com.example.movieshql.dto;

import com.example.movieshql.dto.GenreDto;
import com.example.movieshql.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link Movie}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto implements Serializable {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
    private String title;
    private BigDecimal rating;
    private Long awards;
    private Instant releaseDate;
    private Long length;
    private GenreDto genre;
}