package com.ospina.socialmeli.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import jakarta.validation.constraints.*;

@AllArgsConstructor
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDTO {

    @JsonProperty("product_id")
    @NotNull(message = "The product_id field cannot be empty")
    @Positive(message = "The product_id field must be greater than zero")
    private Long productId;

    @NotBlank(message = "The product_name field cannot be empty")
    @Size(max = 40, message = "The length of the product_name field cannot exceed 40 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The product_name field cannot have special characters")
    @JsonProperty("product_name")
    private String productName;

    @NotBlank(message = "The type field cannot be empty")
    @Size(max = 15, message = "The length of the type field cannot exceed 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The type field cannot have special characters")
    private String type;

    @NotBlank(message = "El campo brand no puede estar vacío")
    @Size(max = 25, message = "La longitud del campo no puede superar los 25 caracteres")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "El campo brand no puede poseer caracteres especiales")
    @JsonProperty("brand")
    private String brand;

    @NotBlank(message = "The color field cannot be empty")
    @Size(max = 15, message = "The length of the color field cannot exceed 15 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The color field cannot have special characters")
    @JsonProperty("color")
    private String color;

    @Size(max = 80, message = "The length of the notes field cannot exceed 80 characters")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "The notes field cannot have special characters")
    @JsonProperty("notes")
    private String notes;

}
