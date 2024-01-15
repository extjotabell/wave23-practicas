package com.meli.movies.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class EpisodesDTO {
    private List<EpisodeDTO> episodes;
}
