package com.example.ejercicioHQL.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class SeriesDto {
    private Integer id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
}
