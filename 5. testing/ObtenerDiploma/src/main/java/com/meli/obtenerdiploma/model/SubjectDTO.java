package com.meli.obtenerdiploma.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
  @NotBlank(message = "El nombre de la materia no puede estar vacío.")
  @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
  @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
  String name;

  @NotNull
  @DecimalMin(value = "0.0")
  @DecimalMax(value = "10.0")
  Double score;
}
