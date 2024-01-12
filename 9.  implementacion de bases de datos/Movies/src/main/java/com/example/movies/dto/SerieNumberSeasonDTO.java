package com.example.movies.dto;

import com.example.movies.models.Season;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SerieNumberSeasonDTO {
  private Integer id;
  private String title;
  private Date releaseDate;
  private Date endDate;
  private Long numberSeasons;
}
