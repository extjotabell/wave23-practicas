package com.mercadolibre.be_java_hisp_w23_g2.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@JsonPropertyOrder({"user_id","post_id","date","product","category","price","has_promo","discount"})
public class PostPromoDTO extends PostDTO{

    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

    public PostPromoDTO(int userId, int id, LocalDate date, ProductDTO product, String category, double price,
                        boolean hasPromo, double discount) {
        super(userId, id, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
