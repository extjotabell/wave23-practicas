package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre de la materia no puede superar los 50 caracteres.")
    String name;

    @DecimalMax(value = "10.0" , message = "La calificación máxima es 10.0")
    @DecimalMin(value = "0.0" , message = "La calificación minima es 0.0")
    @NotNull(message = "La calificación no puede estar vacía")
    Double score;
}
