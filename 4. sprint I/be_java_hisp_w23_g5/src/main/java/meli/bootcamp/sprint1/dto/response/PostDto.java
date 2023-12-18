package meli.bootcamp.sprint1.dto.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostDto {
  private int user_id;
  private int post_id;
  private LocalDate date;
  private ProductDto product;
  private int category;
  private double price;
}
