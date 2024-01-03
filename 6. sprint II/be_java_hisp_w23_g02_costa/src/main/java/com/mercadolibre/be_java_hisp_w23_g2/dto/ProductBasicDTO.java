package com.mercadolibre.be_java_hisp_w23_g2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"product_id", "product_name", "type", "brand", "color", "notes"})
public class ProductBasicDTO {

  @NotNull(message = "El id no puede estar vacío")
  @Positive(message = "El id debe ser mayor a cero")
  @JsonProperty("product_id")
  private Integer id;

  @NotEmpty(message = "El nombre no puede estar vacío")
  @Size(max = 40, message = "La longitud del nombre no puede superar los 40 caracteres")
  @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El nombre no puede poseer caracteres especiales")
  @JsonProperty("product_name")
  private String name;

  @NotEmpty(message = "El tipo no puede estar vacío")
  @Size(max = 15, message = "La longitud del tipo no puede superar los 15 caracteres")
  @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El tipo no puede poseer caracteres especiales")
  private String type;

  @NotEmpty(message = "La marca no puede estar vacía")
  @Size(max = 25, message = "La longitud de la marca no puede superar los 25 caracteres")
  @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "La marca no puede poseer caracteres especiales")
  private String brand;

  @NotEmpty(message = "El color no puede estar vacío")
  @Size(max = 15, message = "La longitud del color no puede ser mayor a 15")
  @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "El color no puede poseer caracteres especiales")
  private String color;

  @Size(max = 80, message = "La longitud de las notas no pueden superar los 80 caracteres")
  @Pattern(regexp = "^[a-zA-Z0-9 ]+$", message = "Las notas no puede poseer caracteres especiales")
  private String notes;
}
