package meli.bootcamp.sprint1.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import meli.bootcamp.sprint1.dto.response.NewProductDto;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewPromoPostDto {

  private int user_id;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate date;
  private NewProductDto product;
  private int category;
  private double price;
  private boolean has_promo;
  private double discount;


}
