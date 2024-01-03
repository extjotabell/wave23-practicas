package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.request.ProductDTO;
import com.example.be_java_hisp_w23_g3.dto.response.PostResponseDTO;

import java.time.LocalDate;

public class PostResponseDTOTestDataBuilder {

    private Long userId;
    private Long postId;
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private Double price;

    public PostResponseDTOTestDataBuilder postResponseDTOByDefault() {
        this.userId = 1L;
        this.postId = 101L;
        this.date = LocalDate.now();
        this.product = new ProductDTOTestDataBuilder().productDTOByDefault().build();
        this.category = 1;
        this.price = 100.0;
        return this;
    }

    public PostResponseDTOTestDataBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public PostResponseDTOTestDataBuilder withPostId(Long postId) {
        this.postId = postId;
        return this;
    }

    public PostResponseDTOTestDataBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public PostResponseDTOTestDataBuilder withProduct(ProductDTO product) {
        this.product = product;
        return this;
    }

    public PostResponseDTOTestDataBuilder withCategory(int category) {
        this.category = category;
        return this;
    }

    public PostResponseDTOTestDataBuilder withPrice(Double price) {
        this.price = price;
        return this;
    }

    public PostResponseDTO build() {
        return new PostResponseDTO(userId, postId, date, product, category, price);
    }
}
