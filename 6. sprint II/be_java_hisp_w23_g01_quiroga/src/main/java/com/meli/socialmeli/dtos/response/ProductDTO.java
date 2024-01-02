package com.meli.socialmeli.dtos.response;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDTO {
    @NotNull(message = "El  campo 'product_id' no puede estar vacío.")
    @Min(value= 1, message= "El campo 'product_id' debe ser mayor a cero")
    private Integer product_id;
    @NotBlank(message = "El campo 'product_name' no puede estar vacío.")
    @Size(max=40, message = "La longitud del campo 'product_name' no puede superar los 40 caracteres.")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "El campo 'product_name' no puede poseer caracteres especiales.")
    private String product_name;
    @NotBlank(message = "El campo 'type' no puede estar vacío.")
    @Size(max=15, message = "La longitud del campo 'type' no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "El campo 'type' no puede poseer caracteres especiales.")
    private String type;
    @NotBlank(message = "El campo 'brand' no puede estar vacío.")
    @Size(max=25, message = "La longitud del campo 'brand' no puede superar los 25 caracteres.")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "El campo 'brand' no puede poseer caracteres especiales.")
    private String brand;
    @NotBlank(message = "El campo 'color' no puede estar vacío.")
    @Size(max=15, message = "La longitud del campo 'color' no puede superar los 15 caracteres.")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "El campo 'color' no puede poseer caracteres especiales.")
    private String color;
    @NotBlank(message = "El campo 'notes' no puede estar vacío.")
    @Size(max=80, message = "La longitud del campo 'notes' no puede superar los 80 caracteres.")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "El campo 'notes' no puede poseer caracteres especiales.")
    private String notes;
}
