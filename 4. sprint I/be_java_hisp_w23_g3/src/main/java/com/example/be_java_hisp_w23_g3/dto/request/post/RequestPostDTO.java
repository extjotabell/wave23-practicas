package com.example.be_java_hisp_w23_g3.dto.request.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class RequestPostDTO {
    @JsonProperty("user_id")
    @NotNull
    private Long userId;
    @NotNull
    private LocalDate date;
    @NotNull
    private RequestProductDTO product;
    @NotNull
    private int category;
    @NotNull
    private Double price;

    public RequestPostDTO(Long userId, LocalDate date, RequestProductDTO product, int category, Double price) {
        this.userId = userId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public RequestProductDTO getProduct() {
        return product;
    }

    public int getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }
}
