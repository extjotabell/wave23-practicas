package meli.bootcamp.sprint1.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import meli.bootcamp.sprint1.dto.response.NewProductDto;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewPostDto {

  private int user_id;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
  private LocalDate date;
  private NewProductDto product;
  private int category;
  private double price;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private boolean has_promo;
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private double discount;

}
