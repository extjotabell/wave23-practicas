package com.example.movies.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpisodeSimpleDTO {
  private Integer id;
  private String title;
  private Integer number;
  private BigDecimal rating;
  private Date releaseDate;
}
