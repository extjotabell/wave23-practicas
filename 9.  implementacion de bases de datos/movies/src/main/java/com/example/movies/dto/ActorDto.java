package com.example.movies.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ActorDto implements Serializable {
    Long id;
    Instant createdAt;
    Instant updatedAt;
    String firstName;
    String lastName;
    BigDecimal rating;
    MovieDto favoriteMovie;
}
