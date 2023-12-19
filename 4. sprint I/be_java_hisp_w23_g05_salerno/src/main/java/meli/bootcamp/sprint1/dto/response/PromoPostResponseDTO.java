package meli.bootcamp.sprint1.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor @AllArgsConstructor @Getter
public class PromoPostResponseDTO {

    private Integer user_id;
    private Integer post_id;
    private LocalDate date;
    private ProductDto product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;

}
