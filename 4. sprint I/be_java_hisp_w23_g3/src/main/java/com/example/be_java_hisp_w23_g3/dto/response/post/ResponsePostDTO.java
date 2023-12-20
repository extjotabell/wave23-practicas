package com.example.be_java_hisp_w23_g3.dto.response.post;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class ResponsePostDTO {
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("post_id")
    private String postId;
    private LocalDate date;
    private ResponseProductDTO product;
    private int category;
    private Double price;

    public ResponsePostDTO(Long userId, String postId, LocalDate date, ResponseProductDTO product, int category, Double price) {
        this.userId = userId;
        this.postId = postId;
        this.date = date;
        this.product = product;
        this.category = category;
        this.price = price;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPostId() {
        return postId;
    }

    public LocalDate getDate() {
        return date;
    }

    public ResponseProductDTO getProduct() {
        return product;
    }

    public int getCategory() {
        return category;
    }

    public Double getPrice() {
        return price;
    }
}
