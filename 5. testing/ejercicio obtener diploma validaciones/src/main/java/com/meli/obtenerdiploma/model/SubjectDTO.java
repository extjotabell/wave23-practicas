package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacía.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotBlank(message = "La nota no puede estar vacía.")
    @DecimalMin(value = "0", inclusive = true, message = "La mínima nota es 0.")
    @DecimalMax(value = "10", inclusive = true, message = "La máxima nota es 10.")
    Double score;

}
