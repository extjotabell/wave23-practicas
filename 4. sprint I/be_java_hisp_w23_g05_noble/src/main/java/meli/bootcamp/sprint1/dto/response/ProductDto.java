package meli.bootcamp.sprint1.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ProductDto {
  @JsonProperty("id")
  private int productId;
  @JsonProperty("name")
  private String productName;
  private String type;
  private String brand;
  private String color;
  private String notes;
}
