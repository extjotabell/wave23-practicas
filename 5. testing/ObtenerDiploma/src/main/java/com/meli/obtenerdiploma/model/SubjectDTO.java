package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Getter @Setter
@Validated
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(min = 3, max = 50, message = "La longitud del nombre de la materia no puede ser menor a 3 ni superar los 50 caracteres.")
    String name;
    @NotNull(message = "La nota no puede estar vacía.")
    @Min( value = 0, message = "La minima nota es 0.0.")
    @Max( value = 10, message = "La máxima nota es 10.0.")
    Double score;
}
