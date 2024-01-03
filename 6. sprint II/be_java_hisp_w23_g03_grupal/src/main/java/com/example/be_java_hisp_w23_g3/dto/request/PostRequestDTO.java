package com.example.be_java_hisp_w23_g3.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.*;

import jakarta.validation.*;

@AllArgsConstructor
@Getter
public class PostRequestDTO {

    @NotNull(message = "The user_id cannot be empty")
    @Positive(message = "The user_id must be greater than zero")
    @JsonProperty("user_id")
    private Long userId;

    @NotBlank(message = "The date cannot be empty")
    @JsonProperty("date")
    private String date;

    @Valid
    @JsonProperty("product")
    private ProductDTO product;

    @NotNull(message = "The category cannot be empty")
    @JsonProperty("category")
    private int category;

    @NotNull(message = "The price cannot be empty")
    @DecimalMax(value = "10000000", message = "The price cannot be greater than $10'000.000")
    @JsonProperty("price")
    private Double price;

}
