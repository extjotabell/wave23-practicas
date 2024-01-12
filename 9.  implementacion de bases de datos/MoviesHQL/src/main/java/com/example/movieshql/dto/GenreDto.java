package com.example.movieshql.dto;

import com.example.movieshql.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Genre}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto implements Serializable {
    private Long id;
    private Instant createdAt;
    private Instant updatedAt;
    private String name;
    private Long ranking;
    private Boolean active = false;
}