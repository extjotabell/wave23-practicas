package com.mercadolibre.be_java_hisp_w23_g2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.mercadolibre.be_java_hisp_w23_g2.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostPromo extends Post{
    @JsonProperty("has_promo")
    private boolean hasPromo;
    private double discount;

    public PostPromo(int id, int userId, LocalDate date, Product product, String category, double price,
                     boolean hasPromo,
                     double discount) {
        super(id, userId, date, product, category, price);
        this.hasPromo = hasPromo;
        this.discount = discount;
    }
}
