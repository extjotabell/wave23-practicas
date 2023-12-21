package meli.bootcamp.sprint1.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PromoPostDto {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
