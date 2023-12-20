package com.example.be_java_hisp_w23_g3.entity;

import com.example.be_java_hisp_w23_g3.util.ArgumentValidator;

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
        ArgumentValidator.validateRequired(id, "Id is required");
        ArgumentValidator.validateRequired(name, "Name is required");
        ArgumentValidator.validateRequired(type, "Type is required");
        ArgumentValidator.validateRequired(brand, "Brand is required");
        ArgumentValidator.validateRequired(color, "Color is required");
        ArgumentValidator.validateRequired(notes, "Notes is required");
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
