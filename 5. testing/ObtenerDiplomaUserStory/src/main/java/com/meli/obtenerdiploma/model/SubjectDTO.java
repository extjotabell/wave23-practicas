package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayuscula")
    @NotEmpty(message = "El nombre de la materia no puede estar vacio")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;
    @NotNull(message = "La nota no puede estar vacia")
    @DecimalMin(value = "0", message = "La minima nota es 0.0")
    @DecimalMax(value = "10.0", message = "La maxima nota es 10.0")
    Double score;
}
