package com.example.movies.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActorsDTO {
    private Long id;
    private LocalDate createdAt;
    private LocalDate updateAt;
    private String firstName;
    private String lastName;
    private Double rating;
}
