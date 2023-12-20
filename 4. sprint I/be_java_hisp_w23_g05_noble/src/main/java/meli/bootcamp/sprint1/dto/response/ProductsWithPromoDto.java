package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductsWithPromoDto {
    private int user_id;
    private String user_name;
    private Long promo_products_count;
}
