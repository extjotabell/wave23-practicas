package com.example.ejercicioHQL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeDto {

    private Integer id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;

}
