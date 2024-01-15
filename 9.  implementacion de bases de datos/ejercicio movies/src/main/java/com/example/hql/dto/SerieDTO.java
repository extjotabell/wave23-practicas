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
public class SerieDTO {
    private Long id;
    private LocalDate createdAt, updatedAt, releaseDate, endDate;
    private String title;
}