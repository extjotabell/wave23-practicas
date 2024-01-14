package com.meli.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class SeriesDTO {
    private List<SerieDTO> series;
}
