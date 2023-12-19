package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class US0011Dto {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
