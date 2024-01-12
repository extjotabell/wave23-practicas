package com.practice.movies.dto;

import com.practice.movies.model.Season;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO {
    private Integer id;
    private String title;
    private Integer number;
    private LocalDate release_date;
    private Double rating;
    private Integer season_id;
}
