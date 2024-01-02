package meli.bootcamp.sprint1.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class NewProductDto {
  @NotNull(message = "El id no puede estar vacio.")
  @Min(message = "El id debe ser mayor a 0.", value = 1)
  private int product_id;

  @NotBlank(message = "El campo product_name no puede estar vacio.")
  @Size(max = 40, message = "La longitud no puede superar los 40 caracteres.")
  @Pattern(regexp="^[\\w\\s]*$", message = "El campo product_name no puede poseer caracteres especiales.")
  private String product_name;

  @NotBlank(message = "El campo type no puede estar vacio.")
  @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
  @Pattern(regexp="^[\\w\\s]*$", message = "El campo type no puede poseer caracteres especiales.")
  private String type;

  @NotBlank(message = "El campo brand no puede estar vacio.")
  @Size(max = 25, message = "La longitud no puede superar los 25 caracteres.")
  @Pattern(regexp="^[\\w\\s]*$", message = "El campo brand no puede poseer caracteres especiales.")
  private String brand;

  @NotBlank(message = "El campo color no puede estar vacio.")
  @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
  @Pattern(regexp="^[\\w\\s]*$", message = "El campo color no puede poseer caracteres especiales.")
  private String color;

  @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
  @Pattern(regexp="^[\\w\\s]*$", message = "El campo notes no puede poseer caracteres especiales.")
  private String notes;
}
