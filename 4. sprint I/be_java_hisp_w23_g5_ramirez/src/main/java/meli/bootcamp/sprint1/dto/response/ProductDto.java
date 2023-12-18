package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {
  private int product_id;
  private String product_name;
  private String type;
  private String brand;
  private String color;
  private String notes;
}
