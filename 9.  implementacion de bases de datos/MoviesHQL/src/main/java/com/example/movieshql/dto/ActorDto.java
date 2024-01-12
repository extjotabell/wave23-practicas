package com.example.movieshql.dto;

import com.example.movieshql.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link Actor}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDto implements Serializable {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
    private String firstName;
    private String lastName;
    private BigDecimal rating;
    private MovieDto favoriteMovie;
}