package com.practice.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {
    private Integer id;
    private String title;
    private Date release_date;
    private Double rating;
    private List<Integer> seasonsId;
}
