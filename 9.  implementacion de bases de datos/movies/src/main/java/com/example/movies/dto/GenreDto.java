package com.example.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

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
