package com.example.hql.dto;

import com.example.hql.model.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieDTO {
    private Long id;
    private LocalDate createdAt, updatedAt, releaseDate;
    private String title;
    private Double rating;
    private Integer awards, length;
    Set<Actor> actors;
}
