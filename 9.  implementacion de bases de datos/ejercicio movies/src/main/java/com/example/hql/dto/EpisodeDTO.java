package com.example.hql.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDTO {
    private Long id;
    private LocalDate createdAt, updatedAt, releaseDate;
    private String title;
    private Integer number;
    private Double rating;
}
