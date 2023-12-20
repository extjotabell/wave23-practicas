package com.example.be_java_hisp_w23_g3.dto.request.post;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public class RequestProductDTO {
    @JsonProperty("product_id")
    @NotNull
    private Long id;
    @JsonProperty("product_name")
    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private String brand;
    @NotNull
    private String color;
    @NotNull
    private String notes;

    public RequestProductDTO(Long id, String name, String type, String brand, String color, String notes) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
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
}
