package com.ospina.socialmeli.util;

import com.ospina.socialmeli.dto.request.ProductDTO;

public class ProductDTOTestDataBuilder {

    private Long productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductDTOTestDataBuilder productDTOByDefault() {
        this.productId = 1L;
        this.productName = "product name";
        this.type = "type";
        this.brand = "brand";
        this.color = "color";
        this.notes = "notes";
        return this;
    }

    public ProductDTOTestDataBuilder withProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public ProductDTOTestDataBuilder withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductDTOTestDataBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public ProductDTOTestDataBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductDTOTestDataBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    public ProductDTOTestDataBuilder withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public ProductDTO build() {
        return new ProductDTO(productId, productName, type, brand, color, notes);
    }
}
