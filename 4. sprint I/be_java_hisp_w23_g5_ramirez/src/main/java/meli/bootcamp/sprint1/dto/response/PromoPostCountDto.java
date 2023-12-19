package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PromoPostCountDto {
  private int user_id;
  private String user_name;
  private int promo_products_count;
}
