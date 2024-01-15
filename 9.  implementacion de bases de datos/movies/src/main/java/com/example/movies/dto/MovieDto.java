package com.example.movies.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;


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
