package com.bootcamp.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe empezar con mayúsculas.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;

    @NotNull(message = "El valor de la calificación no puede ser nulo.")
    @DecimalMin(value = "0.0", message = "El valor de la calificación debe ser mayor a 0 puntos.")
    @DecimalMax(value = "10.0", message = "El valor de la calificación no puede superar los 10 puntos.")
    Double score;

}
