package com.sprint.be_java_hisp_w23_g04.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sprint.be_java_hisp_w23_g04.dto.response.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown=true )
public class PostDTO {
    @JsonProperty("user_id")
    protected int userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    protected LocalDate date;
    protected ProductDTO product;
    protected int category;
    protected double price;
    @JsonProperty("has_promo")
    protected boolean hasPromo = false;
    protected float discount = 0;
}
