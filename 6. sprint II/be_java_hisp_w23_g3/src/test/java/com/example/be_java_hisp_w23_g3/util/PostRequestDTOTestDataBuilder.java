package com.example.be_java_hisp_w23_g3.util;

import com.example.be_java_hisp_w23_g3.dto.request.ProductDTO;
import com.example.be_java_hisp_w23_g3.dto.request.PostRequestDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PostRequestDTOTestDataBuilder {

    private Long userId;
    private LocalDate date;
    private ProductDTO product;
    private int category;
    private Double price;

    public PostRequestDTOTestDataBuilder postRequestDTOByDefault() {
        this.userId = 1L;
        this.date = LocalDate.now();
        this.product = new ProductDTOTestDataBuilder().productDTOByDefault().build();
        this.category = 1;
        this.price = 100.0;
        return this;
    }

    public PostRequestDTOTestDataBuilder withUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public PostRequestDTOTestDataBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public PostRequestDTOTestDataBuilder withProduct(ProductDTO product) {
        this.product = product;
        return this;
    }

    public PostRequestDTOTestDataBuilder withCategory(int category) {
        this.category = category;
        return this;
    }

    public PostRequestDTOTestDataBuilder withPrice(Double price) {
        this.price = price;
        return this;
    }

    public PostRequestDTO build() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateAsText = date.format(formatter);


        return new PostRequestDTO(
            userId,
            dateAsText,
            product,
            category,
            price
        );
    }
}
