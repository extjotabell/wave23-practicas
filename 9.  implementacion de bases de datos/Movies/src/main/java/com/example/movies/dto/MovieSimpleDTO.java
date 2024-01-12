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
public class MovieSimpleDTO {
  private Integer id;
  private String title;
  private BigDecimal rating;
  private Integer awards;
  private Date releaseDate;
  private Integer length;

}
