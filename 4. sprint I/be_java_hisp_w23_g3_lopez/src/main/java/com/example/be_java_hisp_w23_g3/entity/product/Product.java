package com.example.be_java_hisp_w23_g3.entity.product;

import com.example.be_java_hisp_w23_g3.util.Validator;

public class Product {
    private final Long id;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    private Product(Long id, String name, String type, String brand, String color, String notes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public static Product build(Long id, String name, String type, String brand, String color, String notes) {
        Validator.validateRequired(id, "Product Id is required");
        Validator.validatePositive(id, "Product id is required");
        Validator.validateRequired(name, "Product name is required");
        Validator.validateRequired(type, "Product type is required");
        Validator.validateRequired(brand, "Product brand is required");
        Validator.validateRequired(color, "Product color is required");
        Validator.validateRequired(notes, "Product notes are required");
        return new Product(id, name, type, brand, color, notes);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getNotes() {
        return notes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
