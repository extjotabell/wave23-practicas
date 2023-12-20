package com.sprint.be_java_hisp_w23_g04.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    @JsonProperty("product_id")
    private int id;
    @JsonProperty("product_name")
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
