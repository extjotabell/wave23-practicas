package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Getter
public class ProductsPromoDTO {

    private int user_id;
    private String user_name;
    private int products_promo_count;

}
