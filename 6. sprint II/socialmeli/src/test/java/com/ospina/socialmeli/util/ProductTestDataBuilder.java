package com.ospina.socialmeli.util;

import com.ospina.socialmeli.entity.product.Product;

public class ProductTestDataBuilder {
    private Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductTestDataBuilder productByDefault() {
        this.id = 1L;
        this.name = "name1";
        this.type = "type1";
        this.brand = "brand1";
        this.color = "color1";
        this.notes = "notes1";
        return this;
    }

    public ProductTestDataBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ProductTestDataBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public ProductTestDataBuilder withType(String type) {
        this.type = type;
        return this;
    }

    public ProductTestDataBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ProductTestDataBuilder withColor(String color) {
        this.color = color;
        return this;
    }

    public ProductTestDataBuilder withNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Product build() {
        return Product.build(id, name, type, brand, color, notes);
    }



}
