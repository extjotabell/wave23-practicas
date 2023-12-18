package meli.bootcamp.sprint1.dto.request;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewPostDto {

  private int user_id;
  private LocalDate date;
  private NewProductDto product;
  private int category;
  private double price;

}
